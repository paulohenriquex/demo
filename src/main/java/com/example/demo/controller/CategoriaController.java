package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoriaRequestDTO;
import com.example.demo.dto.CategoriaResponseDTO;
import com.example.demo.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @PostMapping("/cadastrar")
    public CategoriaResponseDTO criar(@RequestBody CategoriaRequestDTO dto){
        return categoriaService.criar(dto);
    }
}
