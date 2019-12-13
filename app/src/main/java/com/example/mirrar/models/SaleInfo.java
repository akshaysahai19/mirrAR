package com.example.mirrar.models;

public class SaleInfo {

    private String sales_person_name;
    private String client_name;
    private String brand_name;
    private String email;
    private String mobile_number;
    private String address;
    private String payment_amount;
    private String payment_mode;

    public SaleInfo() {
    }

    public SaleInfo(String sales_person_name, String client_name, String brand_name, String email,
                    String mobile_number, String address, String payment_amount, String payment_mode) {
        this.sales_person_name = sales_person_name;
        this.client_name = client_name;
        this.brand_name = brand_name;
        this.email = email;
        this.mobile_number = mobile_number;
        this.address = address;
        this.payment_amount = payment_amount;
        this.payment_mode = payment_mode;
    }

    public String getSales_person_name() {
        return sales_person_name;
    }

    public void setSales_person_name(String sales_person_name) {
        this.sales_person_name = sales_person_name;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(String payment_amount) {
        this.payment_amount = payment_amount;
    }

    public String getPayment_mode() {
        return payment_mode;
    }

    public void setPayment_mode(String payment_mode) {
        this.payment_mode = payment_mode;
    }
}
