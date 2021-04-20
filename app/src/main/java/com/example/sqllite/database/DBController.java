package com.example.sqllite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DBController extends SQLiteOpenHelper {
    public DBController(Context context) {
        super(context, "ProdiTI", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table Teman(id integer primary key, nama text, telepon text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table if exists Teman");
        onCreate(db);
    }

    public void InsertData(HashMap<String,String> QueryValues) {
        SQLiteDatabase BasisData = this.getWritableDatabase();
        ContentValues Nilai = new ContentValues();
        Nilai.put("Nama", QueryValues.get("Nama"));
        Nilai.put("Telepon", QueryValues.get("Telepon"));
        BasisData.insert("Teman", null, Nilai);
        BasisData.close();
    }

    public ArrayList<HashMap<String, String>> getAllTeman() {
        ArrayList<HashMap<String, String>> DaftarTeman;
        DaftarTeman = new ArrayList<HashMap<String, String>>();
        String SelectQuery = "Select * From Teman";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(SelectQuery, null);
        if(cursor.moveToFirst()){
            do {
                HashMap<String, String> map = new HashMap<>();
                map.put("id", cursor.getString(0));
                map.put("Nama", cursor.getString(1));
                map.put("Telepon", cursor.getString(2));
                DaftarTeman.add(map);
            } while (cursor.moveToNext());
        }
        db.close();
        return DaftarTeman;
    }
}