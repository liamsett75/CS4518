package com.example.myfirstapp;

import android.util.Log;

public class User {

    private Boolean isLoggedOn;
    private String guestUser;
    private String guestPass;

    public String getGuestUser() {
        return guestUser;
    }

    public String getGuestPass() {
        return guestPass;
    }

    public void setIsLoggedOn(){
        isLoggedOn = true;
    }

    public User(String guestUser, String guestPass, Boolean isLoggedOn){
        this.guestPass = guestPass;
        this.guestUser = guestUser;
        this.isLoggedOn = isLoggedOn;
    }

}
