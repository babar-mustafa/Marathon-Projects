package com.example.babarmustafa.parkingsystem.Models;

/**
 * Created by BabarMustafa on 1/27/2017.
 */

public class USer_POsition {
    String position_a;
    String hours;
    String date;

    public USer_POsition() {
    }

    public USer_POsition(String position_a, String hours, String date) {
        this.position_a = position_a;
        this.hours = hours;
        this.date = date;
    }

    public USer_POsition(String position_a) {
        this.position_a = position_a;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPosition_a() {
        return position_a;
    }

    public void setPosition_a(String position_a) {
        this.position_a = position_a;
    }
}
