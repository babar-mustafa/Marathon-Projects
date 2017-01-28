package com.example.babarmustafa.auctionsystem.Models;

/**
 * Created by BabarMustafa on 1/28/2017.
 */

//public class Data_Mobiles {
//}

public class Data_Mobiles {
    String name_products;
    String p_city;
    String p_id;


    public Data_Mobiles() {
    }

    public Data_Mobiles(String name_products, String p_city, String p_id) {
        this.name_products = name_products;
        this.p_city = p_city;
        this.p_id = p_id;
    }

    public String getName_products() {
        return name_products;
    }

    public void setName_products(String name_products) {
        this.name_products = name_products;
    }

    public String getP_city() {
        return p_city;
    }

    public void setP_city(String p_city) {
        this.p_city = p_city;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }
}
