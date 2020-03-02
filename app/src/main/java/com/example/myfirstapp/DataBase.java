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
    RegisterActivity ra;

    public static final String DATABASE_NAME = "client.db";
    public static final String TABLE_NAME = "client_table";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "USERNAME";
    public static final String COL_3 = "PASSWORD";
    public static final String COL_4 = "PIN";
    public static final String COL_5 = "BALANCE";

    public DataBase(Context context){
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COL_1 + " TEXT," + COL_2 + " TEXT," + COL_3 + " TEXT," + COL_4 + " TEXT," + COL_5 + " INT" + ")";
        db.execSQL(CREATE_USER_TABLE);
    }

    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        User newUser = new User(user.getName(), user.getGuestUser(), user.getGuestPass(), user.getPin(),true, 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, newUser.getName());
        contentValues.put(COL_2, newUser.getGuestUser());
        contentValues.put(COL_3, newUser.getGuestPass());
        contentValues.put(COL_4, newUser.getPin());
        contentValues.put(COL_5, newUser.getBalance());
        Log.d(TAG, "addUser: Adding " + newUser.getGuestUser() + "as a new user.");
        db.insert(TABLE_NAME, null, contentValues);
        db.close();

    }

    public void showDB(SQLiteDatabase db){
        db.execSQL("SELECT * FROM TABLE_NAME" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
}
