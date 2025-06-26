package com.example.apibanco.services;

import com.example.apibanco.models.Transaction;
import com.example.apibanco.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public void salvar(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public List<Transaction> imprimirTransacoes() {
       return transactionRepository.findAll();
    }

    public void apagar() {
        transactionRepository.deleteAll();
    }
}
