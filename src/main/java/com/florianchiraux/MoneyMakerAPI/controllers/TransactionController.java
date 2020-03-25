package com.florianchiraux.MoneyMakerAPI.controllers;

import com.florianchiraux.MoneyMakerAPI.model.Transaction;
import com.florianchiraux.MoneyMakerAPI.repositories.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class TransactionController {
    @Autowired
    private TransactionRepo repo;

    @PostMapping(path="/addTransaction")
    public @ResponseBody
    String addNewTransaction (@RequestParam double amount
            , @RequestParam double price, @RequestParam String type) {

        Transaction n = new Transaction(amount, price, type);
        repo.save(n);
        return "Saved";
    }

    @GetMapping(path="/transactions")
    public @ResponseBody Iterable<Transaction> getAllTransactions() {
        return repo.findAll();
    }
}
