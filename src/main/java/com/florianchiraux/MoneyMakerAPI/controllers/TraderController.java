package com.florianchiraux.MoneyMakerAPI.controllers;

import com.florianchiraux.MoneyMakerAPI.model.Trader;
import com.florianchiraux.MoneyMakerAPI.repositories.TraderRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TraderController {
    @Autowired
    private TraderRepo traderRepo;

    @PostMapping(path = "/addTrader")
    public @ResponseBody
    String addNewTrader(@RequestParam String name, @RequestParam String pwd) {
        Trader n = new Trader(name, pwd);
        traderRepo.save(n);
        return "Trader registered";
    }

    @GetMapping(path = "/traders")
    public @ResponseBody
    Iterable<Trader> getAllTraders() {
        return traderRepo.findAll();
    }
}
