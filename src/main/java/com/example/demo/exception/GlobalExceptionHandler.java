package com.example.demo.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> tratarErrosDeValidacao(MethodArgumentNotValidException ex){
        List<String> listaDeErros = new ArrayList<>();

        for(FieldError erro: ex.getBindingResult().getFieldErrors()){
            String nomeDoCampo = erro.getField();
            String mensagem = erro.getDefaultMessage();

            listaDeErros.add(nomeDoCampo + ": " + mensagem);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaDeErros);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> tratarEntidadeNaoEncontrada(EntityNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aviso: " + ex.getMessage());
    }
}
