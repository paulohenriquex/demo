package com.example.demo.dto;

public record UserResponseDTO(
    Long id,
    String email,
    String password,
    String role
) {
    
}