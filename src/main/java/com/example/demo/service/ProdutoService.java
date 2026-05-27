package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.example.demo.dto.ProdutoRequestDTO;
import com.example.demo.dto.ProdutoResponseDTO;
import com.example.demo.model.Categoria;
import com.example.demo.model.Marca;
import com.example.demo.model.Produto;
import com.example.demo.model.User;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.MarcaRepository;
import com.example.demo.repository.ProdutoRepository;
import com.example.demo.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final MarcaRepository marcaRepository;
    private final CategoriaRepository categoriaRepository;
    private final UserRepository userRepository;


    public ProdutoService(ProdutoRepository produtoRepository, MarcaRepository marcaRepository, CategoriaRepository categoriaRepository, UserRepository userRepository){
        this.produtoRepository = produtoRepository;
        this.marcaRepository = marcaRepository;
        this.categoriaRepository= categoriaRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public ProdutoResponseDTO criar(ProdutoRequestDTO dto){
        Produto p = new Produto();
        p.setNome(dto.nome());
        p.setPreco(dto.preco());
        p.setMedida(dto.medida());

        User usuario = userRepository.findById(dto.userId())
        .orElseThrow(()-> new EntityNotFoundException("Usuário não encontrado."));
        Marca marca = marcaRepository.findById(dto.marcaId())
        .orElseThrow(()-> new EntityNotFoundException("Marca não encotrada."));
        Categoria categoria = categoriaRepository.findById(dto.categoriaId())
        .orElseThrow(()-> new EntityNotFoundException("Categoria não encontrada."));
        
        p.setMarca(marca);
        p.setCategoria(categoria);
        p.setUser(usuario);
        Produto salvo = produtoRepository.save(p);
        return converterEmDTO(salvo);

    }

    public List<ProdutoResponseDTO> listarTodos(){
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(this::converterEmDTO)
                .collect(Collectors.toList());
    }

    public ProdutoResponseDTO converterEmDTO(Produto p){
        return new ProdutoResponseDTO(
            p.getId(),
            p.getNome(),
            p.getPreco(),
            p.getMedida(),
            p.getMarca().getId(),
            p.getCategoria().getId()
        );
    }
}
