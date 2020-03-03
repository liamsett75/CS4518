package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
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


import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private ImageView login_background;

    public EditText usernameText;
    public EditText passwordText;

    private static SharedPreferences mPreferences;
    private String sharedPrefFile =
            "com.example.android.hellosharedprefs";

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameText = (EditText)findViewById(R.id.usernameText);
        passwordText = (EditText)findViewById(R.id.passwordText);

        SharedPreferences.Editor preferencesEditor = getmPreferences().edit();


        // deletes all accounts
        //preferencesEditor.clear();
        //preferencesEditor.apply();

        Set<String> userInfo = new HashSet<>();
        userInfo.add("nLiam");
        userInfo.add("p1234");
        userInfo.add("i1111");
        userInfo.add("b0");
        preferencesEditor.putStringSet("lsetterlund", userInfo);
        preferencesEditor.apply();

    }

    public void openLogin(View view) {
        setContentView(R.layout.activity_second);
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void loginEnter(View view) {
        if(mPreferences.contains(usernameText.getText().toString())) {
            Set<String> userInfo = mPreferences.getStringSet(usernameText.getText().toString(), null);
            if(userInfo.contains("p" + passwordText.getText().toString())) {
                Toast toast = Toast.makeText(this, R.string.login_message, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 400);
                toast.show();
                openLogin(view);
            }
            else {
                Toast toast = Toast.makeText(this, R.string.login_failed, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 400);
                toast.show();
            }
        }
        else {
            Toast toast = Toast.makeText(this, R.string.login_failed, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 400);
            toast.show();
        }
    }

    public void registerEnter(View view) {
        setContentView(R.layout.activity_register);
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    protected static SharedPreferences getmPreferences() {
        return mPreferences;
    }

}
