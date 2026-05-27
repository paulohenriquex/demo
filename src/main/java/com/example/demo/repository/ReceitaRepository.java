package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}