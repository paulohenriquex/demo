package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.FichaTecnicaRequestDTO;
import com.example.demo.dto.FichaTecnicaResponseDTO;
import com.example.demo.dto.IngredienteRequestDTO;
import com.example.demo.dto.IngredienteResponseDTO;
import com.example.demo.model.FichaTecnica;
import com.example.demo.model.Ingrediente;
import com.example.demo.model.Produto;
import com.example.demo.model.Receita;
import com.example.demo.model.User;
import com.example.demo.repository.FichaTecnicaRepository;
import com.example.demo.repository.ProdutoRepository;
import com.example.demo.repository.ReceitaRepository;
import com.example.demo.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class FichaTecnicaService {
    
    private final FichaTecnicaRepository fichaTecnicaRepository;
    private final ReceitaRepository receitaRepository;
    private final ProdutoRepository produtoRepository;
    private final UserRepository userRepository;

    public FichaTecnicaService(FichaTecnicaRepository fichaTecnicaRepository,ReceitaRepository receitaRepository,ProdutoRepository produtoRepository,UserRepository userRepository){
        this.fichaTecnicaRepository = fichaTecnicaRepository;
        this.receitaRepository = receitaRepository;
        this.produtoRepository = produtoRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public FichaTecnicaResponseDTO criar(FichaTecnicaRequestDTO dto){
        
            User usuario = userRepository.findById(dto.userId())
            .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado."));

            Receita receita = receitaRepository.findById(dto.receitaId())
            .orElseThrow(() -> new EntityNotFoundException("Receita não encontrado."));

           FichaTecnica fichaTecnica = new FichaTecnica();
           fichaTecnica.setUser(usuario);
           fichaTecnica.setReceita(receita);
           fichaTecnica.setIngredientes(new ArrayList<>());

           for(IngredienteRequestDTO ingDTO: dto.ingredientes()){

                Produto produto = produtoRepository.findById(ingDTO.produtoId())
                .orElseThrow(()-> new EntityNotFoundException("Produto ID " + ingDTO.produtoId() + " não encontrado."));

                Ingrediente ingrediente = new Ingrediente();
                ingrediente.setProduto(produto);
                ingrediente.setPercapita(ingDTO.percapita());

                ingrediente.setFichaTecnica(fichaTecnica);

                fichaTecnica.getIngredientes().add(ingrediente);
           }

           FichaTecnica fichaSalva = fichaTecnicaRepository.save(fichaTecnica);
           return converterEmDTO(fichaSalva);
        }

        public FichaTecnicaResponseDTO converterEmDTO(FichaTecnica f){
            List<IngredienteResponseDTO> listaIngredientesDTO = new ArrayList<>();

            for(Ingrediente ing: f.getIngredientes()){
                listaIngredientesDTO.add(new IngredienteResponseDTO(
                    ing.getId(),
                    ing.getProduto().getNome(),
                    ing.getPercapita(),
                    ing.getCustoItem()
                ));
            }

            return new FichaTecnicaResponseDTO(
                f.getId(),
                f.getReceita().getNome(),
                f.getCustoTotal(),
                listaIngredientesDTO
            );
        }
}
