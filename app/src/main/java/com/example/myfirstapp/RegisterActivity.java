package com.example.myfirstapp;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

import static android.content.ContentValues.TAG;

public class RegisterActivity extends AppCompatActivity {
    public EditText registerNameText;
    public EditText registerUsernameText;
    public EditText registerPwdText;
    public EditText registerPINText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerNameText = (EditText)findViewById(R.id.registerNameText);
        registerUsernameText = (EditText)findViewById(R.id.registerUserText);
        registerPwdText = (EditText)findViewById(R.id.registerPwdText);
        registerPINText = (EditText)findViewById(R.id.registerPINText);
    }


    public void backToMain(View view) {
        setContentView(R.layout.activity_main);
    }

    public void addUser(View view) {

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

        else if(MainActivity.getmPreferences().contains(registerUsernameText.getText().toString())) {
            Toast toast = Toast.makeText(this, "Username already exists", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 400);
            toast.show();
        }

        else if (!strongPassword(registerPwdText.getText().toString())) {
            Toast toast = Toast.makeText(this, "Passwords should contain both letters and numbers and should be at least 8 characters long", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 400);
            toast.show();
        }

        else {
            SharedPreferences.Editor preferencesEditor = MainActivity.getmPreferences().edit();
            Set<String> userInfo = new HashSet<>();
            userInfo.add("n" + registerNameText.getText().toString());
            userInfo.add("p" + registerPwdText.getText().toString());
            userInfo.add("i" + registerPINText.getText().toString());
            userInfo.add("b0");
            preferencesEditor.putStringSet(registerUsernameText.getText().toString(), userInfo);
            preferencesEditor.apply();

            setContentView(R.layout.activity_main);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            Toast toast = Toast.makeText(this, "New account successfully created", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 400);
            toast.show();

        }


    }

    public boolean strongPassword(String password) {
        boolean hasChar = false;
        boolean hasNum = false;
        char[] chars = password.toCharArray();
        for(char c : chars) {
            if(Character.isLetter((c)))
                hasChar = true;
            if(Character.isDigit(c))
                hasNum = true;
        }

        return hasChar && hasNum && password.length() >= 8;
    }
}
