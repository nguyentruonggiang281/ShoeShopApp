package com.example.appbangiaycomplete;

public class Order {
    private String userName;
    private String idProdDetails;
    private String amountOrder;
    private String totalCost;
    private String delivery;
    private String state;

    public Order(String userName, String idProdDetails, String amountOrder, String totalCost, String delivery, String state) {
//     user name
        this.userName = userName;
//        id
        this.idProdDetails = idProdDetails;
        this.amountOrder = amountOrder;
        this.totalCost = totalCost;
//        địa chỉ
        this.delivery = delivery;
//        trạng thái
        this.state = state;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdProdDetails() {
        return idProdDetails;
    }

    public void setIdProdDetails(String idProdDetails) {
        this.idProdDetails = idProdDetails;
    }

    public String getAmountOrder() {
        return amountOrder;
    }

    public void setAmountOrder(String amountOrder) {
        this.amountOrder = amountOrder;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
