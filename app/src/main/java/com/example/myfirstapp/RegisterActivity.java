package com.example.myfirstapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static android.content.ContentValues.TAG;
import static com.example.myfirstapp.DataBase.COL_1;
import static com.example.myfirstapp.DataBase.COL_2;
import static com.example.myfirstapp.DataBase.COL_3;
import static com.example.myfirstapp.DataBase.COL_4;
import static com.example.myfirstapp.DataBase.COL_5;
import static com.example.myfirstapp.DataBase.TABLE_NAME;

public class RegisterActivity extends AppCompatActivity {
    public EditText registerNameText;
    public EditText registerUsernameText;
    public EditText registerPwdText;
    public EditText registerPINText;
    DataBase dbHelp;
   // MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dbHelp = new DataBase(this);
        registerNameText = (EditText)findViewById(R.id.registerNameText);
        registerUsernameText = (EditText)findViewById(R.id.registerUserText);
        registerPwdText = (EditText)findViewById(R.id.registerPwdText);
        registerPINText = (EditText)findViewById(R.id.registerPINText);
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

    public void addUser(User user) {

        if(registerNameText.getText().toString().equals("")){
            Toast toast = Toast.makeText(this, R.string.blank_name, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 400);
            toast.show();
        }

        else if(registerUsernameText.getText().toString().equals("")){
            Toast toast = Toast.makeText(this, R.string.blank_username, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 400);
            toast.show();
        }

        else if(registerPwdText.getText().toString().equals("")){
            Toast toast = Toast.makeText(this, R.string.blank_pwd, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 400);
            toast.show();
        }

        else if(registerPINText.getText().toString().equals("")){
            Toast toast = Toast.makeText(this, R.string.blank_pin, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 400);
            toast.show();
        }

        User newUser = new User(registerNameText.getText().toString(), registerUsernameText.getText().toString(), registerPwdText.getText().toString(), registerPINText.getText().toString(), true, 0);
//        SQLiteDatabase db = this
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, newUser.getName());
        contentValues.put(COL_2, newUser.getGuestUser());
        contentValues.put(COL_3, newUser.getGuestPass());
        contentValues.put(COL_4, newUser.getPin());
        contentValues.put(COL_5, newUser.getBalance());
        Log.d(TAG, "addUser: Adding " + newUser.getGuestUser() + "as a new user.");


    }
}
