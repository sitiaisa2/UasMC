package com.example.myresep


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class LandingPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_landingpage)

        val masuk = findViewById<Button>(R.id.btn_masuk)
        val keluar = findViewById<Button>(R.id.btn_logout)

        masuk.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        keluar.setOnClickListener {
            logout()
        }
    }

    private fun logout() {
        FirebaseAuth.getInstance().signOut()
        navigateToLoginPage()
    }

    private fun navigateToLoginPage() {
        val intent = Intent(this, Login::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

}