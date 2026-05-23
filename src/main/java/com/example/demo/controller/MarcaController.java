package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MarcaRequestDTO;
import com.example.demo.dto.MarcaResponseDTO;
import com.example.demo.service.MarcaService;

@RestController
@RequestMapping("/marca")
public class MarcaController {
    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService){
        this.marcaService = marcaService;
    }

    @PostMapping("/cadastrar")
    public MarcaResponseDTO criar(@RequestBody MarcaRequestDTO dto){
        return marcaService.criar(dto);
    }
}
