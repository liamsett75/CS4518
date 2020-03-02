package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private ArrayList<User> userList = new ArrayList<User>();
    private User user1 = new User("Liam", "lsetterlund", "1234", "1234", false, 0); //Can handle this in a database later on...

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        userList.add(user1);

    }
//
//    public void backToMain(View view){
//
//        setContentView(R.layout.activity_main);
//
//    }


}
