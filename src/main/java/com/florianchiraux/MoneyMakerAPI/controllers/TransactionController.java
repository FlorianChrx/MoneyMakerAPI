package com.florianchiraux.MoneyMakerAPI.controllers;

import com.florianchiraux.MoneyMakerAPI.model.FIFOCalculator;
import com.florianchiraux.MoneyMakerAPI.model.Trader;
import com.florianchiraux.MoneyMakerAPI.model.Transaction;
import com.florianchiraux.MoneyMakerAPI.repositories.TraderRepo;
import com.florianchiraux.MoneyMakerAPI.repositories.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TransactionController {
    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private TraderRepo traderRepo;

    @PostMapping(path = "/{trader}/transactions/add")
    public @ResponseBody
    String addNewTransaction(@PathVariable String trader, @RequestParam String pwd, @RequestParam double amount
            , @RequestParam double price, @RequestParam String type) {

        Optional<Trader> trader1 = traderRepo.findById(trader);
        Trader trader2 = trader1.get();
        if (!trader2.getPwd().equals(pwd)) {
            return "Error: Authentication failed !";
        }

        if (!(type.equalsIgnoreCase("buy") || type.equalsIgnoreCase("sell"))) {
            return "Error: Unknown transaction type";
        }

        Transaction n = new Transaction(trader2, amount, price, type);
        transactionRepo.save(n);
        return "Saved";
    }

    @GetMapping(path = "/{trader}/transactions")
    public @ResponseBody
    Iterable<Transaction> getAllTransactionsOfTrader(@PathVariable String trader, @RequestParam String pwd) {
        Iterable<Transaction> transactions = transactionRepo.findAll();
        List<Transaction> result = new ArrayList<Transaction>();
        for (Transaction t : transactions) {
            if (t.getTrader().getId().equals(trader)) {
                result.add(t);
            }
        }
        return result;
    }

    @GetMapping(path = "/{trader}/average")
    public @ResponseBody
    double getAveragePriceOfTrader(@PathVariable String trader, @RequestParam String pwd, @RequestParam String type) {
        return FIFOCalculator.getAveragePrice(getAllTransactionsOfTrader(trader, pwd), type);
    }
}
