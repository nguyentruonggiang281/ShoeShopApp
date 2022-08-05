package com.example.appbangiaycomplete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductAdmin implements Serializable {
    private String idProc;
    private ArrayList<Image> imageProduct;
//    private int imageProduct;
    private String ProductName;
    private String brand;
    private int price;
    private int amount;
    private String description;
    private int size;
    private String color;

    public ProductAdmin(String idProc, ArrayList<Image> imageProduct, String productName, String brand, int price, int amount, String description, int size, String color) {
        this.idProc = idProc;
        this.imageProduct = imageProduct;
        ProductName = productName;
        this.brand = brand;
        this.price = price;
        this.amount = amount;
        this.description = description;
        this.size = size;
        this.color = color;
    }

    public ArrayList<Image> getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(ArrayList<Image> imageProduct) {
        this.imageProduct = imageProduct;
    }

    public String getIdProc() {
        return idProc;
    }

    public void setIdProc(String idProc) {
        this.idProc = idProc;
    }


    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
