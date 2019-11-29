package com.example.firstandroidtp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class database extends SQLiteOpenHelper {
    private static final String COL_ID="id";
    private static final String COL_NOM="nom";
    private static final String COL_CONTACT="contact";
    public database(Context context, String name, SQLiteDatabase.CursorFactory factory,int version) {
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BDD = "CREATE TABLE contact("
                + COL_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +COL_NOM + " TEXT NOT NULL,"
                +COL_CONTACT + " INTEGER NOT NULL);";
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE table_contact ;");

    }

}

