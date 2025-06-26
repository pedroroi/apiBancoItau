package com.example.apibanco.controllers;

import com.example.apibanco.dtos.TransactionDTO;
import com.example.apibanco.models.Transaction;
import com.example.apibanco.services.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transacao")
    public ResponseEntity<Transaction> salvar(@Valid @RequestBody TransactionDTO transactionDTO) {

        Transaction transaction = new Transaction();
        transaction.setValor(transactionDTO.valor());
        transaction.setDataHora(transactionDTO.dataHora());

        transactionService.salvar(transaction);

        return new ResponseEntity<Transaction>(transaction, HttpStatus.CREATED);
    }

    @DeleteMapping("/transacao")
    public ResponseEntity<String> apagar() {
        transactionService.apagar();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/transacao")
    public ResponseEntity<List<Transaction>> imprimirTransacoes() {

        List<Transaction> transactions = transactionService.imprimirTransacoes();

        if(transactions.isEmpty()){
            return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.FOUND);
        }
    }

}
