package com.example.firstandroidtp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "android.db";
    private static final String TB_NAME = "contact";
    private static final String COL_ID="id";
    private static final String COL_NOM="nom";
    private static final String COL_NUM="numero";


    public DatabaseHelper( Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TB_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT NOT NULL,  numero TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TB_NAME);
    }

    public boolean inserer(String nom, String num){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NOM, nom);
        contentValues.put(COL_NUM, num);
        long result = db.insert(TB_NAME, null, contentValues);
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+ TB_NAME, null);
        return res;
    }

    public Integer delete(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TB_NAME, COL_ID +" = ?", new String[] {String.valueOf(id)});
    }

    public boolean update(String id, String nom, String num){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID, id);
        contentValues.put(COL_NOM, nom);
        contentValues.put(COL_NUM, num);
        db.update(TB_NAME, contentValues, "id = ?", new String[] {id});
        return true;
    }
}
