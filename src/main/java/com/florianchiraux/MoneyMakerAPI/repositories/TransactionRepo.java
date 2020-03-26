package com.florianchiraux.MoneyMakerAPI.repositories;

import com.florianchiraux.MoneyMakerAPI.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported = false)
public interface TransactionRepo extends CrudRepository<Transaction, Integer> {
}