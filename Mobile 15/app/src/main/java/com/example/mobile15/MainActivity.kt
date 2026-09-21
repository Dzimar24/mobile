package com.example.mobile15

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MahasiswaAdapter
    private var mahasiswaArrayList = ArrayList<Mahasiswa>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addData()

        recyclerView = findViewById(R.id.recycle_view)

        adapter = MahasiswaAdapter(mahasiswaArrayList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun addData() {
        mahasiswaArrayList = ArrayList<Mahasiswa>()
        mahasiswaArrayList.add(Mahasiswa("Dimas Maulana", "1414370309", "123456789"))
        mahasiswaArrayList.add(Mahasiswa("Fadly Yonk", "1214234560", "987654321"))
        mahasiswaArrayList.add(Mahasiswa("Ariyandi Nugraha", "1214230345", "987648765"))
        mahasiswaArrayList.add(Mahasiswa("Aham Siswana", "1214378098", "098758124"))
    }
}