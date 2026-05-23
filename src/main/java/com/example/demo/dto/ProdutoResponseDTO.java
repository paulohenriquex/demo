package com.example.demo.dto;

import java.math.BigDecimal;

public record ProdutoResponseDTO(
    Long id,
    String nome,
    BigDecimal preco,
    Long marcaId,
    Long categoriaId
) {
    
}
