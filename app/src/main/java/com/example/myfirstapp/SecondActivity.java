package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    public EditText usernameText;
    public EditText passwordText;

    private ArrayList<User> userList = new ArrayList<User>();
    private User user1 = new User("lsetterlund", "1234", false, 0); //Can handle this in a database later on...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        userList.add(user1);

        usernameText = (EditText)findViewById(R.id.usernameText);
        passwordText = (EditText)findViewById(R.id.passwordText);
    }

//    public void backToMain(View view){
//
//        setContentView(R.layout.activity_main);
//
//    }
}
