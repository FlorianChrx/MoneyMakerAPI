package com.florianchiraux.MoneyMakerAPI.repositories;

import com.florianchiraux.MoneyMakerAPI.model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepo extends CrudRepository<Transaction, Integer> {
}