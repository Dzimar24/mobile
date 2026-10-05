package com.example.mobile26

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private var STORAGE_PERMISSION_CODE = 23

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById<EditText>(R.id.editTextTwo)
    }

    fun next(view: View) {
        val intent = Intent(this, MainTwoActivity::class.java)
        startActivity(intent)
    }

    fun savePublic(view: View) {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
            STORAGE_PERMISSION_CODE
        )
        val info = editText.text.toString()
        val folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val myFile = File(folder, "myDataOne.txt")
        writeData(myFile, info)
        editText.setText("")
    }

    fun savePrivate(view: View) {
        val info = editText.text.toString()
        val folder = getExternalFilesDir("arvita")
        val myFile = File(folder, "myDataTwo.txt")
        writeData(myFile, info)
        editText.setText("")
    }

    private fun writeData(myFile: File, data: String){
        var fileOutputStream: FileOutputStream? = null
        try {
            println("Test")
            fileOutputStream = FileOutputStream(myFile)
            fileOutputStream.write(data.toByteArray())
            Toast.makeText(this, "Done " + myFile.absolutePath, Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }
}