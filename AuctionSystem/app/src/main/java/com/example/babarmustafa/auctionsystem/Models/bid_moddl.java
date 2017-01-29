package com.example.babarmustafa.auctionsystem.Models;

/**
 * Created by babar on 1/29/2017.
 */

public class bid_moddl {
    String bidded;
    String bider_name;
    String bider_email;

    public bid_moddl() {
    }

    public bid_moddl(String bidded, String bider_name) {
        this.bidded = bidded;
        this.bider_name = bider_name;
    }

    public bid_moddl(String bidded, String bider_name, String bider_email) {
        this.bidded = bidded;
        this.bider_name = bider_name;
        this.bider_email = bider_email;
    }

    public bid_moddl(String bidded) {
        this.bidded = bidded;
    }

    public String getBider_name() {
        return bider_name;
    }

    public void setBider_name(String bider_name) {
        this.bider_name = bider_name;
    }

    public String getBider_email() {
        return bider_email;
    }

    public void setBider_email(String bider_email) {
        this.bider_email = bider_email;
    }

    public String getBidded() {
        return bidded;
    }

    public void setBidded(String bidded) {
        this.bidded = bidded;
    }
}
