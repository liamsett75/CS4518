package com.example.myfirstapp;

import android.util.Log;

public class User {

    private Boolean isLoggedOn;
    private String name;
    private String guestUser;
    private String guestPass;
    private String pin;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double balance;

    public double getBalance() {
        return balance;
    }

    public String getName() { return name; }

    public String getGuestUser() {
        return guestUser;
    }

    public String getGuestPass() {
        return guestPass;
    }

    public String getPin() { return pin; }

    public void setIsLoggedOn(){
        isLoggedOn = true;
    }

    public User(String name, String guestUser, String guestPass, String pin, Boolean isLoggedOn, double balance){
        this.name = name;
        this.guestPass = guestPass;
        this.guestUser = guestUser;
        this.pin = pin;
        this.isLoggedOn = isLoggedOn;
        this.balance = balance;
    }

}
