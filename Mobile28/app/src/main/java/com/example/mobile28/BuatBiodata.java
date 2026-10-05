package com.example.mobile28;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BuatBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3, text4, text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_biodata);

        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.editTextOne);
        text2 = (EditText) findViewById(R.id.editTextTwo);
        text3 = (EditText) findViewById(R.id.editTextTree);
        text4 = (EditText) findViewById(R.id.editTextFour);
        text5 = (EditText) findViewById(R.id.editTextFive);
        ton1 = (Button) findViewById(R.id.buttonOne);
        ton2 = (Button) findViewById(R.id.buttonTwo);

        ton1.setOnClickListener((arg0) -> {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.execSQL("INSERT INTO biodata(no, name, tgl, jk, alamat) VALUES ('" +
                    text1.getText().toString() + "', '" +
                    text2.getText().toString() + "', '" +
                    text3.getText().toString() + "', '" +
                    text4.getText().toString() + "', '" +
                    text5.getText().toString() + "')");
            Toast.makeText(getApplicationContext(), "Berhasil!", Toast.LENGTH_LONG).show();
            if (MainActivity.ma != null) {
                MainActivity.ma.refreshList();
            }
            finish();
        });

        ton2.setOnClickListener((arg0) -> {
            finish();
        });
    }
}
