@file:Suppress("DEPRECATION")

package com.example.myresep

import android.content.Intent
import android.os.Bundle

import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailResep : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_detail_resep)


        val detail = intent.getParcelableExtra<Resep>(Home.INTENT_PARCELABLE)

        val img = findViewById<ImageView>(R.id.Imgdetail)
        val title = findViewById<TextView>(R.id.titleDetail)
        val dec = findViewById<TextView>(R.id.desDetail)

        img.setImageResource(detail!!.R_image)
        title.text = detail.R_title
        dec.text = detail.R_des

        val back = findViewById<ImageView>(R.id.kembali)
        back.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

    }
}