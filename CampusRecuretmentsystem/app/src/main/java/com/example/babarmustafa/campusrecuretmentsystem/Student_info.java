package com.example.babarmustafa.campusrecuretmentsystem;

/**
 * Created by BabarMustafa on 1/25/2017.
 */


public class Student_info {


    private String UID;
    private String Name;
    private String Email;
    private String Password;
    private String GEnder;
    private String Profile_image;

    public Student_info() {
    }

    public Student_info(String UID, String profile_image) {
        this.UID = UID;
        Profile_image = profile_image;
    }

    public Student_info(String profile_image) {
        Profile_image = profile_image;
    }

    public Student_info(String UID, String name, String email, String password, String GEnder) {
        this.UID = UID;
        Name = name;
        Email = email;
        Password = password;
        this.GEnder = GEnder;
    }

    public Student_info(String UID, String name, String email, String password, String GEnder, String Profile_image) {
        this.UID = UID;
        Name = name;
        Email = email;
        Password = password;
        this.GEnder = GEnder;
        this.Profile_image = Profile_image;
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

    public String getProfile_image() {
        return Profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.Profile_image = profile_image;
    }
}
