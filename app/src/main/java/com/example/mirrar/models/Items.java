package com.example.mirrar.models;

import java.io.Serializable;

public class Items implements Serializable {

    private String name;
    private String value;
    private long amount;

    public Items(String name, String value, long amount) {
        this.name = name;
        this.value = value;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
