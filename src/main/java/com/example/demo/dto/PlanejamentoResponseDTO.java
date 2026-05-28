package com.example.demo.dto;

import java.time.LocalDate;
import java.util.List;

public record PlanejamentoResponseDTO(
    Long id,
    String nomeContrato,
    String tipoServico,
    LocalDate dataEntrega,
    Integer quantitativo,
    List<ItemPlanejamentoResponseDTO> itens
) {
    
}
