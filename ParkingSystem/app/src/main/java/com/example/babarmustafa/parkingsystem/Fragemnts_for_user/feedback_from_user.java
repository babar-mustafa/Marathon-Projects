package com.example.babarmustafa.parkingsystem.Fragemnts_for_user;

/**
 * Created by BabarMustafa on 1/27/2017.
 */

public class feedback_from_user {
    String push_id;
    private String Name;
    private String Email;
    String fedback;

    public feedback_from_user(String push_id, String name, String email, String fedback) {
        this.push_id = push_id;
        Name = name;
        Email = email;
        this.fedback = fedback;
    }

    public feedback_from_user() {
    }

    public String getPush_id() {
        return push_id;
    }

    public void setPush_id(String push_id) {
        this.push_id = push_id;
    }

    public feedback_from_user(String name, String email, String fedback) {
        Name = name;
        Email = email;
        this.fedback = fedback;
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

    public String getFedback() {
        return fedback;
    }

    public void setFedback(String fedback) {
        this.fedback = fedback;
    }
}
