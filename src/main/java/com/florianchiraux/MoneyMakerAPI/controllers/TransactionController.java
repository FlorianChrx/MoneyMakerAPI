package com.florianchiraux.MoneyMakerAPI.controllers;

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

    @PostMapping(path = "/addTransaction")
    public @ResponseBody
    String addNewTransaction(@RequestParam String name, @RequestParam double amount
            , @RequestParam double price, @RequestParam String type) {

        Optional<Trader> trader = traderRepo.findById(name);

        Transaction n = new Transaction(trader.get(), amount, price, type);
        transactionRepo.save(n);
        return "Saved";
    }

    @GetMapping(path = "/transactions/{trader}")
    public @ResponseBody
    Iterable<Transaction> getAllTransactionsOfTrader(@PathVariable String trader) {
        Iterable<Transaction> transactions = transactionRepo.findAll();
        List<Transaction> result = new ArrayList<Transaction>();
        for (Transaction t : transactions) {
            if (t.getTrader().equals(traderRepo.findById(trader))) {
                result.add(t);
            }
        }
        return result;
    }

    @GetMapping(path = "/transactions")
    public @ResponseBody
    Iterable<Transaction> getAllTransactions() {
        return transactionRepo.findAll();
    }
}
