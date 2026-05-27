package com.example.demo.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProdutoRequestDTO(
    @NotBlank(message = "O nome do produto é obrigatório")
    String nome,

    @NotNull(message = "O preço é obrigatório")
    @Positive(message = "O preço deve ser maior que zero")
    BigDecimal preco,

    @NotBlank(message = "A medida do produto é obrigatório")
    String medida,

   @NotNull(message = "O ID da marca é obrigatório")
    Long marcaId,

    @NotNull(message = "O ID da categoria é obrigatório")
    Long categoriaId,

    @NotNull(message = "O ID do usuário responsável é obrigatório")
    Long userId
) {
    
}
