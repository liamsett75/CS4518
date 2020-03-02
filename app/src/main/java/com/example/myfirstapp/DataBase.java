package com.example.myfirstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.Nullable;

import static android.content.ContentValues.TAG;

public class DataBase extends SQLiteOpenHelper {
    EditText registerUsernameText;
    EditText registerPwdText;

    public static final String DATABASE_NAME = "client.db";
    public static final String TABLE_NAME = "client_table";
    public static final String COL_1 = "FIRSTNAME";
    public static final String COL_2 = "LASTNAME";
    public static final String COL_3 = "USERNAME";
    public static final String COL_4 = "PASSWORD";
    public static final String COL_5 = "BALANCE";

    public DataBase(Context context){
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRSTNAME TEXT, LASTNAME TEXT, USERNAME TEXT, PASSWORD TEXT, BALANCE INT)");
        db.execSQL("SELECT * FROM TABLE_NAME");
    }

    public void addUser(String username, String password){
        username = registerUsernameText.getText().toString();
        password = registerPwdText.getText().toString();

        User newUser = new User(username, password, true, 0);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_3, newUser.getGuestUser());
        contentValues.put(COL_4, newUser.getGuestPass());
        contentValues.put(COL_5, newUser.getBalance());
        Log.d(TAG, "addUser: Adding " + newUser.getGuestUser() + "as a new user.");

        db.insert(TABLE_NAME, null, contentValues);


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
