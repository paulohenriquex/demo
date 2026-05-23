package com.example.demo.dto;

public record UserRequestDTO(
    String email,
    String password,
    String role
) {
    
}
