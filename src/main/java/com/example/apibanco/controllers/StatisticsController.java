package com.example.apibanco.controllers;

import com.example.apibanco.services.StatisticsService;
import com.example.apibanco.services.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StatisticsController {

    @Autowired
    StatisticsService statisticService;

    @GetMapping("/estatistica")
    public ResponseEntity<Map<String, Object>> obterEstatisticas() {
        Map<String, Object> estatisticas = statisticService.calcularEstatisticas();
        return ResponseEntity.ok(estatisticas);
    }
}
