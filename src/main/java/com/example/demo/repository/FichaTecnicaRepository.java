package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.example.demo.model.FichaTecnica;
    
@Repository
public interface FichaTecnicaRepository extends JpaRepository<FichaTecnica, Long> {
}
