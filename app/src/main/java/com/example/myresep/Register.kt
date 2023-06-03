package com.example.myresep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.myresep.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        firebaseAuth = FirebaseAuth.getInstance()

        binding.rbtnRegister.setOnClickListener{
            val username : String = binding.rUsername.text.toString().trim()
            val email : String = binding.rEmail.text.toString().trim()
            val password : String = binding.rpass.text.toString().trim()

            if(username.isEmpty()){
                binding.rUsername.error = "Input username"
                binding.rUsername.requestFocus()
                return@setOnClickListener

            } else if(email.isEmpty()) {
                binding.rEmail.error = "Input email"
                binding.rEmail.requestFocus()
                return@setOnClickListener

            } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.rEmail.error = "Email tidak valid"
                binding.rEmail.requestFocus()
                return@setOnClickListener

            } else if(password.isEmpty() || password.length < 8){
                binding.rpass.error = "Minimal 8 karakter dan Tidak boleh kosong"
                binding.rpass.requestFocus()
                return@setOnClickListener

            }else {
                registerUser(email, password)
            }

        }
    }

    private fun registerUser(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if(it.isSuccessful){
                Intent(this, Login::class.java).also{
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }

            }else{
                Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
            }
        }
    }


}