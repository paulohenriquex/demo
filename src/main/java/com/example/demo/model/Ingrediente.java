package com.example.demo.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double percapita;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "ficha_tecnica_id")
    private FichaTecnica fichaTecnica;

    public BigDecimal getCustoItem(){

        if(produto == null || produto.getPreco() ==null || percapita ==null){
            return BigDecimal.ZERO;
        }
        
        return produto.getPreco().multiply(BigDecimal.valueOf(percapita));
    }


}
