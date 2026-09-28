package com.example.mobile23

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var buttonSend: Button

    private val KEY_NAME = "NAME"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById<EditText>(R.id.editName)
        buttonSend = findViewById<Button>(R.id.btnSend)

        buttonSend.setOnClickListener {
            try {
                val name = name.text.toString().trim()

                if (name.isNotEmpty()){
                    val intent = Intent(this, SecondActivity::class.java).apply {
                        putExtra(KEY_NAME, name)
                    }
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "You Need to Fill Your Name", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this, "ERROR, Try Again!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}