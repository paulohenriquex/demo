package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/cadastrar")
    public UserResponseDTO criar(@RequestBody @Valid UserRequestDTO dto){
        System.out.println("Recebendo requisição para cadastrar usuário: " + dto.email());
        return userService.criar(dto);
    }

    @GetMapping("/listar")
    public List<UserResponseDTO> listarTodosUsuarios(){
        return userService.listarTodosUsuarios();
    }
}
