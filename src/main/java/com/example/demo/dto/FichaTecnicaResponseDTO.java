package com.example.demo.dto;

import java.math.BigDecimal;
import java.util.List;

public record FichaTecnicaResponseDTO(
    Long id,
    String nomeReceita,
    BigDecimal custoTotal,
    List<IngredienteResponseDTO> ingredientes
) {
}