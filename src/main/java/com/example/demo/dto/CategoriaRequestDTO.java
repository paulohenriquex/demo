package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRequestDTO(
    @NotBlank(message = "O nome da categoria é obrigatório")
    String nome
) {
    
}
