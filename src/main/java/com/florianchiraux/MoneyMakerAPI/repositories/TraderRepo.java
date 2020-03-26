package com.florianchiraux.MoneyMakerAPI.repositories;

import com.florianchiraux.MoneyMakerAPI.model.Trader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported = false)
public interface TraderRepo extends CrudRepository<Trader, String> {
}
