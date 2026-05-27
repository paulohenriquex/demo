package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record IngredienteRequestDTO(
    @NotNull(message = "O ID do produto é obrigatório")
    Long produtoId,

    @NotNull(message = "A quantidade (percapita) é obrigatório")
    @Positive(message = "A quantidade deve ser maior que zero")
    Double percapita
) {
    
}
