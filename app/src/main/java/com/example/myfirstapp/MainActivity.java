package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
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

import static android.content.ContentValues.TAG;
import static com.example.myfirstapp.DataBase.COL_1;
import static com.example.myfirstapp.DataBase.COL_2;
import static com.example.myfirstapp.DataBase.COL_3;
import static com.example.myfirstapp.DataBase.COL_4;
import static com.example.myfirstapp.DataBase.COL_5;
import static com.example.myfirstapp.DataBase.TABLE_NAME;

public class MainActivity extends AppCompatActivity {
    private ImageView login_background;
    public static DataBase myDb;

    public EditText usernameText;
    public EditText passwordText;

    private ArrayList<User> userList = new ArrayList<User>();
    private User user1 = new User("Liam", "lsetterlund", "1234", "1234", false, 0); //Can handle this in a database later on...

    public EditText registerUsernameText;
    public EditText registerPwdText;
    private SharedPreferences mPreferences;
    private String sharedPrefFile =
            "com.example.android.hellosharedprefs";

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    public static DataBase getMyDb() {
        return myDb;
    }

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
/* Already in RegisterActivity.java
    public void addUser(View view) {
        String username = registerUsernameText.getText().toString();
        String password = registerPwdText.getText().toString();
        User newUser = new User("", username, password, "",true, 0);
        SQLiteDatabase db = getMyDb().getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, newUser.getName());
        contentValues.put(COL_2, newUser.getGuestUser());
        contentValues.put(COL_3, newUser.getGuestPass());
        contentValues.put(COL_4, newUser.getPin());
        contentValues.put(COL_5, newUser.getBalance());
        Log.d(TAG, "addUser: Adding " + newUser.getGuestUser() + "as a new user.");

        db.insert(TABLE_NAME, null, contentValues);
    }
*/

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
                System.out.println(userList.get(i).getName() + " Has logged in");
                System.out.println(userList.get(i).toString());
                toast.setGravity(Gravity.TOP, 0, 400);
                toast.show();
                openLogin(view);
            } else {
                System.out.println("Username or Password Invalid");
            }
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

//    public void openWebsite(View view) {
//        // Get the URL text.
//        String url = "https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default&gmb=exp&biz=false&flowName=GlifWebSignIn&flowEntry=SignUp";
//        // Parse the URI and create the intent.
//        Uri webpage = Uri.parse(url);
//        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
//
//        // Find an activity to hand the intent and start that activity.
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        } else {
//            Log.d("ImplicitIntents", "Can't handle this intent!");
//        }
//    }

}
