package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageView login_background;
    DataBase myDb;

    private SharedPreferences mPreferences;
    private String sharedPrefFile =
            "com.example.android.hellosharedprefs";

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DataBase(this);
        userList.add(user1);

        usernameText = (EditText)findViewById(R.id.usernameText);
        passwordText = (EditText)findViewById(R.id.passwordText);

    }

    public EditText usernameText;
    public EditText passwordText;

    private ArrayList<User> userList = new ArrayList<User>();
    private User user1 = new User("lsetterlund", "1234", false, 0); //Can handle this in a database later on...

    public void openLogin(View view) {
        setContentView(R.layout.activity_second);
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }

    public void loginEnter(View view) {
        Toast toast = Toast.makeText(this, R.string.login_message, Toast.LENGTH_SHORT);
        for (int i = 0; i < userList.size(); i++) {
            if ((usernameText.getText().toString().equals(userList.get(i).getGuestUser())) && (passwordText.getText().toString().equals(userList.get(i).getGuestPass()))) {
                userList.get(i).setIsLoggedOn();
                System.out.println(userList.get(i).getGuestUser() + " Has logged in");
                System.out.println(userList.get(i).toString());
                toast.setGravity(Gravity.TOP, 0, 400);
                toast.show();
                openLogin(view);
            } else {
                System.out.println("Username or Password Invalid");
            }
        }
    }

    public void openWebsite(View view) {
        // Get the URL text.
        String url = "https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default&gmb=exp&biz=false&flowName=GlifWebSignIn&flowEntry=SignUp";
        // Parse the URI and create the intent.
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // Find an activity to hand the intent and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

}
