package com.example.demo.dto;

import java.math.BigDecimal;

public record ProdutoRequestDTO(
    String nome,
    BigDecimal preco,
    Long marcaId,
    Long categoriaId,
    Long userId
) {
    
}
