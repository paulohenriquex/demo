package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.FichaTecnicaRequestDTO;
import com.example.demo.dto.FichaTecnicaResponseDTO;
import com.example.demo.service.FichaTecnicaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/ficha-tecnica")
public class FichaTecnicaController {

    private final FichaTecnicaService fichaTecnicaService;

    public FichaTecnicaController(FichaTecnicaService fichaTecnicaService) {
        this.fichaTecnicaService = fichaTecnicaService;
    }

    @PostMapping("/cadastrar")
    public FichaTecnicaResponseDTO criar(@RequestBody @Valid FichaTecnicaRequestDTO dto) {
        return fichaTecnicaService.criar(dto);
    }
}
