package com.example.myfirstapp;

import android.util.Log;

public class User {

    private Boolean isLoggedOn;
    private String guestUser;
    private String guestPass;
    private int balance;

    public int getBalance() {
        return balance;
    }

    public String getGuestUser() {
        return guestUser;
    }

    public String getGuestPass() {
        return guestPass;
    }

    public void setIsLoggedOn(){
        isLoggedOn = true;
    }

    public User(String guestUser, String guestPass, Boolean isLoggedOn, int balance){
        this.guestPass = guestPass;
        this.guestUser = guestUser;
        this.isLoggedOn = isLoggedOn;
        this.balance = balance;
    }

}
