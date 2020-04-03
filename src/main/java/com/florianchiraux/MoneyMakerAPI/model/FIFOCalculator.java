package com.florianchiraux.MoneyMakerAPI.model;

public class FIFOCalculator {
    public static double getAveragePrice(Iterable<Transaction> transactions, String type){
        double price = 0;
        double quantity = 0;
        for (Transaction t: transactions){
            if (t.getType().equals(type)) {
                price += t.getPrice() * t.getAmount();
                quantity += t.getAmount();
            }
        }
        return price / quantity;
    }
}
