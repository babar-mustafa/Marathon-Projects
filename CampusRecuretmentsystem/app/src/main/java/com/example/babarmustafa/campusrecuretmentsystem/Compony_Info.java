package com.example.babarmustafa.campusrecuretmentsystem;

/**
 * Created by BabarMustafa on 1/25/2017.
 */

public class Compony_Info {

    private String c_UID;
    private String c_Name;
    private String c_Email;
    private String c_Password;
    private String c__webaddress;
    private String c_Profile_image;

    public Compony_Info() {
    }

    public Compony_Info(String c_UID, String c_Name, String c_Email, String c_Password, String c__webaddress, String c_Profile_image) {
        this.c_UID = c_UID;
        this.c_Name = c_Name;
        this.c_Email = c_Email;
        this.c_Password = c_Password;
        this.c__webaddress = c__webaddress;
        this.c_Profile_image = c_Profile_image;
    }

    public Compony_Info(String c_UID, String c_Name, String c_Email, String c_Password, String c__webaddress) {
        this.c_UID = c_UID;
        this.c_Name = c_Name;
        this.c_Email = c_Email;
        this.c_Password = c_Password;
        this.c__webaddress = c__webaddress;
    }

    public String getC_UID() {
        return c_UID;
    }

    public void setC_UID(String c_UID) {
        this.c_UID = c_UID;
    }

    public String getC_Name() {
        return c_Name;
    }

    public void setC_Name(String c_Name) {
        this.c_Name = c_Name;
    }

    public String getC_Email() {
        return c_Email;
    }

    public void setC_Email(String c_Email) {
        this.c_Email = c_Email;
    }

    public String getC_Password() {
        return c_Password;
    }

    public void setC_Password(String c_Password) {
        this.c_Password = c_Password;
    }

    public String getC__webaddress() {
        return c__webaddress;
    }

    public void setC__webaddress(String c__webaddress) {
        this.c__webaddress = c__webaddress;
    }

    public String getC_Profile_image() {
        return c_Profile_image;
    }

    public void setC_Profile_image(String c_Profile_image) {
        this.c_Profile_image = c_Profile_image;
    }


}
