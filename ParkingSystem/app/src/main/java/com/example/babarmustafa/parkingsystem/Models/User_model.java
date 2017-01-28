package com.example.babarmustafa.parkingsystem.Models;

/**
 * Created by BabarMustafa on 1/26/2017.
 */

public class User_model {
    private String UID;
    private String Name;
    private String Email;
    private String Password;
    private String GEnder;


    public User_model() {
    }

    public User_model(String UID, String name, String email, String password, String GEnder) {
        this.UID = UID;
        Name = name;
        Email = email;
        Password = password;
        this.GEnder = GEnder;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getGEnder() {
        return GEnder;
    }

    public void setGEnder(String GEnder) {
        this.GEnder = GEnder;
    }
}
