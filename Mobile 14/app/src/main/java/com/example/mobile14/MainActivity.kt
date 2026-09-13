package com.example.mobile14

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.countries_array,
            android.R.layout.simple_list_item_1
        )
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, _, position, _ ->
            val selectedCountry = parent.getItemAtPosition(position).toString()
            Toast.makeText(this, selectedCountry, Toast.LENGTH_SHORT).show()
        }
    }
}