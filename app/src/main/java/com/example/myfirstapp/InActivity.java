package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class InActivity extends AppCompatActivity {

    public TextView return_message;
    public EditText returnPINText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_in);

        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.dimAmount=0.7f;
        getWindow().setAttributes(lp);

        returnPINText = (EditText)findViewById(R.id.returnPINText);
        return_message = (TextView)findViewById(R.id.return_message);
        Set<String> userInfo = MainActivity.getmPreferences().getStringSet(MainActivity.getLoggedInUser(), null);
        String name = "";
        for(String s : userInfo) {
            if(s.startsWith("n"))
                name = s.substring(1);
        }
        return_message.setText("Welcome back, " + name + ".\nYou timed out.\nPlease enter your PIN to continue.");

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    public void onUserInteraction() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.dimAmount=0f;
        getWindow().setAttributes(lp);
    }

    public void login(View view) {
        Set<String> userInfo = MainActivity.getmPreferences().getStringSet(MainActivity.getLoggedInUser(), null);
        if(userInfo.contains("i" + returnPINText.getText().toString())) {
            Toast toast = Toast.makeText(this, R.string.login_message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 400);
            toast.show();
            this.finish();
        }
        else {
            Toast toast = Toast.makeText(this, "Incorrect PIN", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 400);
            toast.show();
        }
    }

    public void logout(View view) {
        MainActivity.logUserOut();
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
