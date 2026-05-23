package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoriaRequestDTO;
import com.example.demo.dto.CategoriaResponseDTO;
import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;
import jakarta.transaction.Transactional;

@Service
public class CategoriaService {
       private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional
    public CategoriaResponseDTO criar(CategoriaRequestDTO dto){
        Categoria c = new Categoria();
        c.setNome(dto.nome());

        Categoria salvo = categoriaRepository.save(c);
        return converterEmDTO(salvo);
    }

    public CategoriaResponseDTO converterEmDTO(Categoria c){
        return new CategoriaResponseDTO(
            c.getId(),
            c.getNome()
        );
    }
}
