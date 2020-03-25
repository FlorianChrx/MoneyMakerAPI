package com.florianchiraux.MoneyMakerAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double amount;
    private double price;
    private String type;

    public double getAmount() {
        return amount;
    }

    public Transaction() {
    }

    public Transaction(double amount, double price, String type) {
        this.amount = amount;
        this.price = price;
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if(type.equalsIgnoreCase("buy") || type.equalsIgnoreCase("sell")) {
            this.type = type;
        }
    }
}
