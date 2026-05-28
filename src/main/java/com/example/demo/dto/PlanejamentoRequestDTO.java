package com.example.demo.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PlanejamentoRequestDTO(
        @NotNull(message = "O ID do usuário é obrigatório") 
        Long userID,

        @NotBlank(message = "O nome do contrato é obrigatório") 
        String nomeContrato,

        @NotBlank(message = "O tipo de serviço é obrigatório")
        String tipoServico,

        @NotNull(message = "A data de entrega é obrigatória")
        LocalDate dataEntrega,

        @Positive(message = "O quantitativo deve ser maior que zero")
        @NotNull(message = "O quantitativo é obrigatório")
        Integer quantitativo,

        @NotEmpty(message = "A lista de itens do planejamento não pode estar vazia")
        @Valid
        List<ItemPlanejamentoRequestDTO> itens
    ) {
}
