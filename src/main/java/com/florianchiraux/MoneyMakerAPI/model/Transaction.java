package com.florianchiraux.MoneyMakerAPI.model;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private Trader trader;
    private double amount;
    private double price;
    private String type;

    public Transaction(Trader trader, double amount, double price, String type) {
        this.amount = amount;
        this.price = price;
        this.type = type;
        this.trader = trader;
    }

    public Transaction() {};

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if (type.equalsIgnoreCase("buy") || type.equalsIgnoreCase("sell")) {
            this.type = type;
        }
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }
}
