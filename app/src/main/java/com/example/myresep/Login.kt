package com.example.myresep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myresep.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private lateinit var firebaseAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

//      Tombol menuju halaman reset password
        binding.lupapass.setOnClickListener {
            val intent = Intent(this, ForgetPassword::class.java)
            startActivity(intent)
        }

//      Tombol menuju halaman register
        binding.lregister.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        binding.lbtnMasuk.setOnClickListener {
            val email : String = binding.lEmail.text.toString().trim()
            val pass  : String = binding.lpass.text.toString().trim()

            if (email.isEmpty()){
                binding.lEmail.error = "Email Tidak Boleh Kosong"
                binding.lEmail.requestFocus()
                return@setOnClickListener

            }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.lEmail.error = "Email Tidak Valid"
                binding.lEmail.requestFocus()
                return@setOnClickListener

            }else if(pass.isEmpty() || pass.length < 8){
                binding.lpass.error = "Maksimal 8 karakter dan Tidak boleh kosong"
                binding.lpass.requestFocus()
                return@setOnClickListener

            }else{
                loginUser(email,pass)
            }

        }

    }

    private fun loginUser(email: String, pass: String) {
        firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
            if(it.isSuccessful){
                Intent(this, LandingPage::class.java).also{
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }

            }else{
                Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

//    override fun onStart() {
//        super.onStart()
//        if (firebaseAuth.currentUser != null){
//            Intent(this, Login::class.java).also {
//                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                startActivity(it)
//            }
//        }
//    }
}