package com.learning.springjpa.product.data.Repository;

import com.learning.springjpa.product.data.Models.Transactions;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transactions, Integer> {
}
