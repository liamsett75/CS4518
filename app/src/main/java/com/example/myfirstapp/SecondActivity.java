package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    public EditText usernameText;
    public EditText passwordText;

    private ArrayList<User> userList = new ArrayList<User>();
    private User user1 = new User("lsetterlund", "1234", false); //Can handle this in a database later on...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        userList.add(user1);

        usernameText = (EditText)findViewById(R.id.usernameText);
        passwordText = (EditText)findViewById(R.id.passwordText);
    }

    public void loginEnter(View view) {
        for (int i = 0; i < userList.size(); i++) {
            if ((usernameText.getText().toString().equals(userList.get(i).getGuestUser())) && (passwordText.getText().toString().equals(userList.get(i).getGuestPass()))) {
                userList.get(i).setIsLoggedOn();
                System.out.println(userList.get(i).getGuestUser() + " Has logged in");
                System.out.println(userList.get(i).toString());
            } else {
                System.out.println("Username or Password Invalid");
            }
        }
    }




    public void backToMain(View view){

        setContentView(R.layout.activity_main);

    }
}
