package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ItemPlanejamentoRequestDTO;
import com.example.demo.dto.ItemPlanejamentoResponseDTO;
import com.example.demo.dto.PlanejamentoRequestDTO;
import com.example.demo.dto.PlanejamentoResponseDTO;
import com.example.demo.model.FichaTecnica;
import com.example.demo.model.ItemPlanejamento;
import com.example.demo.model.Planejamento;
import com.example.demo.model.User;
import com.example.demo.repository.FichaTecnicaRepository;
import com.example.demo.repository.PlanejamentoRepository;
import com.example.demo.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanejamentoService {
    private final PlanejamentoRepository planejamentoRepository;
    private final FichaTecnicaRepository fichaTecnicaRepository;
    private final UserRepository userRepository;

    @Transactional
    public PlanejamentoResponseDTO criar(PlanejamentoRequestDTO dto){
        User usuario = userRepository.findById(dto.userID())
            .orElseThrow(()-> new EntityNotFoundException("Usuário "+ dto.userID() + " não encontrado."));

        Planejamento planejamento = new Planejamento();
        planejamento.setUser(usuario);
        planejamento.setNomeContrato(dto.nomeContrato());
        planejamento.setTipoServico(dto.tipoServico());
        planejamento.setDataEntrega(dto.dataEntrega());
        planejamento.setQuantitativo(dto.quantitativo());
        planejamento.setItens(new ArrayList<>());

        for(ItemPlanejamentoRequestDTO itemDTO: dto.itens()){
            FichaTecnica ficha = fichaTecnicaRepository.findById(itemDTO.fichaTecnicaId())
            .orElseThrow(()-> new EntityNotFoundException("Ficha Técnica ID " + itemDTO.fichaTecnicaId() + " não encontrada."));
            ItemPlanejamento item = new ItemPlanejamento();
            item.setFichaTecnica(ficha);
            item.setPlanejamento(planejamento);
            planejamento.getItens().add(item);
        }

        Planejamento salvo = planejamentoRepository.save(planejamento);

        return converterEmDTO(salvo);
    }

    public PlanejamentoResponseDTO converterEmDTO(Planejamento p){
        List<ItemPlanejamentoResponseDTO> itensResponse = new ArrayList<>();
        for(ItemPlanejamento item : p.getItens()){
            itensResponse.add(new ItemPlanejamentoResponseDTO(
                item.getId(),
                item.getFichaTecnica().getReceita().getNome()
            ));
        }
        return new PlanejamentoResponseDTO(
            p.getId(),
            p.getNomeContrato(),
            p.getTipoServico(),
            p.getDataEntrega(),
            p.getQuantitativo(),
            itensResponse
        );
    }
}
