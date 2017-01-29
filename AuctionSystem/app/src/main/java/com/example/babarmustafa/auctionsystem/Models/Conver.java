package com.example.babarmustafa.auctionsystem.Models;

/**
 * Created by babar on 1/29/2017.
 */


public class Conver {
    String conversationId;
    String userid;



    public Conver(String conversationId, String userid) {
        this.conversationId = conversationId;
        this.userid = userid;
    }

    public Conver() {
    }

    public Conver(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }



    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
