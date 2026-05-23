package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.MarcaRequestDTO;
import com.example.demo.dto.MarcaResponseDTO;
import com.example.demo.model.Marca;
import com.example.demo.repository.MarcaRepository;

import jakarta.transaction.Transactional;

@Service
public class MarcaService {
    private final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository){
        this.marcaRepository = marcaRepository;
    }

    @Transactional
    public MarcaResponseDTO criar(MarcaRequestDTO dto){
        Marca m = new Marca();
        m.setNome(dto.nome());

        Marca salvo = marcaRepository.save(m);
        return converterEmDTO(salvo);
    }

    public MarcaResponseDTO converterEmDTO(Marca m){
        return new MarcaResponseDTO(
            m.getId(),
            m.getNome()
        );
    }
}
