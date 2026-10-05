package com.example.mobile28

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.time.Instant

class MainActivity : AppCompatActivity() {
    private lateinit var daftar: Array<String?>
    private lateinit var listViewOne: ListView
    private var cursor: Cursor? = null
    private lateinit var dbCenter: DataHelper

    companion object {
        @JvmField
        var ma: MainActivity? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.buttonTwo)
        btn.setOnClickListener {
            val inte = Intent(this@MainActivity, BuatBiodata::class.java)
            startActivity(inte)
        }

        ma = this
        dbCenter = DataHelper(this)
        refreshList()
    }

    fun refreshList() {
        val db = dbCenter.readableDatabase
        cursor = db.rawQuery("SELECT * FROM biodata", null)

        val cursorObj = cursor ?: return
        daftar = arrayOfNulls(cursorObj.count)
        cursorObj.moveToFirst()

        for (cc in 0 until cursorObj.count) {
            cursorObj.moveToPosition(cc)
            daftar[cc] = cursorObj.getString(1)
        }

        listViewOne = findViewById(R.id.listViewOne)
        listViewOne.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar)
        listViewOne.isSelected = true

        listViewOne.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selection = daftar[position]
            val dialogItem = arrayOf<CharSequence>("Lihat Biodata", "Update Biodata", "Hapus Biodata")

            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("Pilihan")
            builder.setItems(dialogItem) { _, item ->
                when (item) {
                    0 -> {
                        val i = Intent(applicationContext, LihatBiodata::class.java)
                        i.putExtra("name", selection)
                        startActivity(i)
                    }
                    1 -> {
                        val `in` = Intent(applicationContext, UpdateBiodata::class.java)
                        `in`.putExtra("name", selection)
                        startActivity(`in`)
                    }
                    2 -> {
                        val dbWrite = dbCenter.writableDatabase
                        dbWrite.execSQL("DELETE FROM biodata WHERE name = '$selection'")
                        refreshList()
                    }
                }
            }
            builder.create().show()
        }
        (listViewOne.adapter as ArrayAdapter<*>).notifyDataSetInvalidated()
    }
}