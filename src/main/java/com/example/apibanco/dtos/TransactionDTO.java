package com.example.apibanco.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.OffsetDateTime;

public record TransactionDTO(

        int id,

        @NotNull(message = "O valor é obrigatório")
        @Positive(message = "O valor deve ser maior que zero!")
        double valor,

        @NotNull(message = "A data/hora é obrigatória")
        @PastOrPresent
        OffsetDateTime dataHora
) {
}
