package com.example.mobile28;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "biodatadiri.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE biodata(no integer primary key, name text null, tgl text null, jk text null, alamat text null);";
        Log.d("Data", "onCrate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO biodata (no, name, tgl, jk, alamat) VALUES ('1', 'Darsiwa', '1996-07-12', 'Laki-Laki', 'Indramayu');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
