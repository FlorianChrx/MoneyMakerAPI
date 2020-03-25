package com.florianchiraux.MoneyMakerAPI.repositories;

import com.florianchiraux.MoneyMakerAPI.model.Trader;
import org.springframework.data.repository.CrudRepository;

public interface TraderRepo extends CrudRepository<Trader, String> {
}
