package com.example.appbangiaycomplete;

import java.io.Serializable;

public class Product02 implements Serializable {
    private int img ;
    private String name ;
    private int price ;
    private int  amount ;

    public Product02(int img, String name, int price, int amount) {
        this.img = img;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
