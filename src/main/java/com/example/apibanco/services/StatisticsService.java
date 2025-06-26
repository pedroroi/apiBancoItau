package com.example.apibanco.services;

import com.example.apibanco.models.Transaction;
import com.example.apibanco.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsService {

    @Autowired
    TransactionRepository transactionRepository;

    public Map<String, Object> calcularEstatisticas() {
        OffsetDateTime limite = OffsetDateTime.now().minusSeconds(60);

        List<Transaction> ultimasTransacoes = transactionRepository.findAll()
                .stream()
                .filter(t -> t.getDataHora().isAfter(limite))
                .toList();

        Map<String, Object> resultado = new HashMap<>();

        if (ultimasTransacoes.isEmpty()) {
            resultado.put("count", 0L);
            resultado.put("sum", 0.0);
            resultado.put("avg", 0.0);
            resultado.put("min", 0.0);
            resultado.put("max", 0.0);
            return resultado;
        }

        DoubleSummaryStatistics stats = ultimasTransacoes.stream()
                .mapToDouble(Transaction::getValor)
                .summaryStatistics();

        resultado.put("count", stats.getCount());
        resultado.put("sum", stats.getSum());
        resultado.put("avg", stats.getAverage());
        resultado.put("min", stats.getMin());
        resultado.put("max", stats.getMax());

        return resultado;
    }
}
