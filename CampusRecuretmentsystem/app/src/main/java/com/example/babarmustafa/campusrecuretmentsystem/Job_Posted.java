package com.example.babarmustafa.campusrecuretmentsystem;

/**
 * Created by BabarMustafa on 1/25/2017.
 */

public class Job_Posted {
    String po_Description;
    String po_Name;

    public String getPo_Name() {
        return po_Name;
    }

    public void setPo_Name(String po_Name) {
        this.po_Name = po_Name;
    }

    public Job_Posted(String po_Description, String po_Name) {

        this.po_Description = po_Description;
        this.po_Name = po_Name;
    }

    public Job_Posted(String po_Description) {
        this.po_Description = po_Description;
    }

    public Job_Posted() {

    }

    public String getPo_Description() {
        return po_Description;
    }

    public void setPo_Description(String po_Description) {
        this.po_Description = po_Description;
    }
}
