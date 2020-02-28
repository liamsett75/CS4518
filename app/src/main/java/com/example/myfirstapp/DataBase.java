package com.example.myfirstapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "client.db";
    public static final String TABLE_NAME = "client_table";
    public static final String COL_1 = "FIRSTNAME";
    public static final String COL_2 = "LASTNAME";
    public static final String COL_3 = "USERNAME";
    public static final String COL_4 = "PASSWORD";
    public static final String COL_5 = "CHECKING";
    public static final String COL_6 = "SAVINGS";

    public DataBase(Context context){
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRSTNAME TEXT, LASTNAME TEXT, USERNAME TEXT, PASSWORD TEXT, CHECKING INT, SAVINGS INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
