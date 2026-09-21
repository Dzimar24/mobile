package com.example.mobile18

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    private lateinit var btnFirstFragment: Button
    private lateinit var btnSecondFragment: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFirstFragment = findViewById(R.id.firstFragment)
        btnSecondFragment = findViewById(R.id.secondFragment)

        btnFirstFragment.setOnClickListener {
            loadFragment(FirstFragment())
        }

        btnSecondFragment.setOnClickListener {
            loadFragment(SecondFragment())
        }
    }

    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()
    }
}