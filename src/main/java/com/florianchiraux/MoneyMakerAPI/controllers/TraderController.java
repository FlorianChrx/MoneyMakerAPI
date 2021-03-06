package com.florianchiraux.MoneyMakerAPI.controllers;

import com.florianchiraux.MoneyMakerAPI.model.Trader;
import com.florianchiraux.MoneyMakerAPI.repositories.TraderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TraderController {
    @Autowired
    private TraderRepo traderRepo;

    @PostMapping(path = "/traders/add/{name}")
    public @ResponseBody
    String addNewTrader(@PathVariable String name, @RequestParam String pwd) {
        Trader n = new Trader(name, pwd);
        if (traderRepo.existsById(n.getId())) {
            return "Error: Trader already exists";
        }
        traderRepo.save(n);
        return "Trader registered";
    }
}
