package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    public LinearLayout parentLinear;
    public TextView deposit_text;
    public Button button0;
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;
    public Button button7;
    public Button button8;
    public Button button9;
    public TextView balance_number;

//    public ImageButton back_btn;
    private ArrayList<User> userList = new ArrayList<User>();
    private User user1 = new User("Liam", "lsetterlund", "1234", "1234", false, 0); //Can handle this in a database later on...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        balance_number = (TextView) findViewById(R.id.balance_number);
        deposit_text = (TextView) findViewById(R.id.deposit_text);
        parentLinear = (LinearLayout) findViewById(R.id.parentLinear);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        userList.add(user1);



    }

    public void clearInput(View view){
        deposit_text = (TextView) findViewById(R.id.deposit_text);
        deposit_text.setText("");
    }

    public void hideWindow(View view){
        parentLinear = (LinearLayout) findViewById(R.id.parentLinear);
        parentLinear.setVisibility(View.GONE);

    }

    public void addToBalance(View view) {
        deposit_text = (TextView) findViewById(R.id.deposit_text);
        balance_number = (TextView) findViewById(R.id.balance_number);
        parentLinear = (LinearLayout) findViewById(R.id.parentLinear);
        Toast toast = Toast.makeText(this, "Deposit Successful", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 400);
        balance_number.setText("$" + deposit_text.getText());
        toast.show();

        parentLinear.setVisibility(View.GONE);
    }

    public void openDeposit(View view) {
        parentLinear = (LinearLayout) findViewById(R.id.parentLinear);
        parentLinear.setVisibility(View.VISIBLE);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        deposit_text = (TextView) findViewById(R.id.deposit_text);
        parentLinear = (LinearLayout) findViewById(R.id.parentLinear);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deposit_text.setText(deposit_text.getText() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deposit_text.setText(deposit_text.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deposit_text.setText(deposit_text.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deposit_text.setText(deposit_text.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deposit_text.setText(deposit_text.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deposit_text.setText(deposit_text.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deposit_text.setText(deposit_text.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deposit_text.setText(deposit_text.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deposit_text.setText(deposit_text.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deposit_text.setText(deposit_text.getText() + "9");
            }
        });

        if (button0.isPressed())
            button0.callOnClick();
        if (button1.isPressed())
            button1.callOnClick();
        if (button2.isPressed())
            button2.callOnClick();
        if (button3.isPressed())
            button3.callOnClick();
        if (button4.isPressed())
            button4.callOnClick();
        if (button5.isPressed())
            button5.callOnClick();
        if (button6.isPressed())
            button6.callOnClick();
        if (button7.isPressed())
            button7.callOnClick();
        if (button8.isPressed())
            button8.callOnClick();
        if (button9.isPressed())
            button9.callOnClick();
    }
}
