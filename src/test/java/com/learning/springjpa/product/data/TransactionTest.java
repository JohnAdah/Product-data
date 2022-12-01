package com.learning.springjpa.product.data;

import com.learning.springjpa.product.data.Models.Transactions;
import com.learning.springjpa.product.data.Repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class TransactionTest {

    @Autowired
    private TransactionRepository transRepo;

    @Test
    public void contextLoad(){

    }

    @Test
    public void createTransaction(){
        Transactions transactions = new Transactions();
        transactions.setTransactionType("buy");
        transactions.setStatus("Successful");

        transRepo.save(transactions);

    }
}
