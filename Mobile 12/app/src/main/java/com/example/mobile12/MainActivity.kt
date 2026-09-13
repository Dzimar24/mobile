package com.example.mobile12

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mobile12.SecondPageActivity
import com.example.mobile12.ThirdPageActivity
import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNextPage = findViewById<Button>(R.id.btn_next_page)
        val btnThirdPage = findViewById<Button>(R.id.btn_third_page)

        btnNextPage.setOnClickListener {
            val intent = Intent(this, SecondPageActivity::class.java)
            startActivity(intent)
        }

        btnThirdPage.setOnClickListener {
            val intent = Intent(this, ThirdPageActivity::class.java)
            startActivity(intent)
        }
    }
}