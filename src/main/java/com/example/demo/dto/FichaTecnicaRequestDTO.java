package com.example.demo.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public record FichaTecnicaRequestDTO(
    @NotNull(message = "O ID do usuário é obrigatório")
    Long userId,

    @NotNull(message = "O ID da receita é obrigatório")
    Long receitaId,

    @NotEmpty(message = "A ficha técnica deve ter pelo menos um ingrediente")
    @NotNull(message = "A lista de ingredientes é obrigatória")
    @Valid
    List<IngredienteRequestDTO> ingredientes
) {
    
}