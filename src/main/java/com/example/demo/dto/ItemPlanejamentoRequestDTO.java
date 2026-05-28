package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;

public record ItemPlanejamentoRequestDTO(
        @NotNull(message = "O ID da ficha técnica é obrigatório") Long fichaTecnicaId) {
}
