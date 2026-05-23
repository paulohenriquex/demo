package com.example.demo.model;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String role;

    @OneToMany(mappedBy = "user")
    private List<Produto> produtos;

    @OneToMany(mappedBy = "user")
    private List<Categoria> categorias;

    @OneToMany(mappedBy = "user")
    private List<Marca> marcas;

    @OneToMany(mappedBy = "user")
    private List<FichaTecnica> fichasTecnias;
}
