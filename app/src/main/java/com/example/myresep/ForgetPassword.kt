package com.example.myresep


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.myresep.databinding.ActivityForgetPasswordBinding
import com.google.firebase.auth.FirebaseAuth

class ForgetPassword : AppCompatActivity() {

    private lateinit var binding : ActivityForgetPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityForgetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.freset.setOnClickListener {
            val email : String = binding.fEmail.text.toString().trim()

            if(email.isEmpty()){
                binding.fEmail.error = "Email Tidak Boleh Kosong"
                binding.fEmail.requestFocus()
                return@setOnClickListener

            } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.fEmail.error = "Email Tidak Valid"
                binding.fEmail.requestFocus()
                return@setOnClickListener

            } else{
                FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener {
                    if(it.isSuccessful){
                        Toast.makeText(this, "Cek email untuk Reset Password", Toast.LENGTH_SHORT).show()
                        Intent(this,Login::class.java).also {
                            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(it)
                        }

                    }else{
                        Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}