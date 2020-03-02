package com.example.myfirstapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import static android.content.ContentValues.TAG;
import static com.example.myfirstapp.DataBase.COL_3;
import static com.example.myfirstapp.DataBase.COL_4;
import static com.example.myfirstapp.DataBase.COL_5;
import static com.example.myfirstapp.DataBase.TABLE_NAME;

public class RegisterActivity extends AppCompatActivity {
    public EditText registerUsernameText;
    public EditText registerPwdText;
    MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerUsernameText = (EditText)findViewById(R.id.usernameText);
        registerPwdText = (EditText)findViewById(R.id.passwordText);
    }

//    public void addUser(String username, String password) {
//        username = mainActivity.registerUsernameText.getText().toString();
//        password = mainActivity.registerPwdText.getText().toString();
//
//        User newUser = new User(username, password, true, 0);
//        SQLiteDatabase db = mainActivity.getMyDb().getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_3, newUser.getGuestUser());
//        contentValues.put(COL_4, newUser.getGuestPass());
//        contentValues.put(COL_5, newUser.getBalance());
//        Log.d(TAG, "addUser: Adding " + newUser.getGuestUser() + "as a new user.");
//
//        db.insert(TABLE_NAME, null, contentValues);
//    }

    public void backToMain(View view) {

        setContentView(R.layout.activity_main);


    }

    public void addUser(View view) {

        User newUser = new User(registerUsernameText.getText().toString(),registerPwdText.getText().toString(), true, 0);
        SQLiteDatabase db = mainActivity.getMyDb().getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_3, newUser.getGuestUser());
        contentValues.put(COL_4, newUser.getGuestPass());
        contentValues.put(COL_5, newUser.getBalance());
        Log.d(TAG, "addUser: Adding " + newUser.getGuestUser() + "as a new user.");

        db.insert(TABLE_NAME, null, contentValues);
    }
}
