package com.example.apibanco.repositories;

import com.example.apibanco.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    public List<Transaction> findByDataHoraAfter(OffsetDateTime dataHora);
}
