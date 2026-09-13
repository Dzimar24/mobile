package com.example.mobile10

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi tombol Next Page
        val btnNextPage = findViewById<Button>(R.id.btn_next_page)

        // Aksi ketika tombol diklik
        btnNextPage.setOnClickListener {
            val intent = Intent(this, SecondPageActivity::class.java)
            startActivity(intent)
        }
    }
}