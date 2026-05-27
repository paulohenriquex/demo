package com.example.demo.dto;

import java.math.BigDecimal;

public record IngredienteResponseDTO(
    Long id,
    String nomeProduto,
    Double percapita,
    BigDecimal custoItem
) {
    
}