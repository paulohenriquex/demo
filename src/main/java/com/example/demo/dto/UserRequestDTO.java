package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(
    @NotBlank(message = "O email não pode estar em branco")
    @Email(message = "Formato de email inválido")
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    String email,

    @NotBlank(message = "A senha não pode estar em branco")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    
    @NotBlank(message = "Senha é obrigatória")
    String password,
    
    @NotBlank(message = "A role (papel) do usuário é obrigatória")
    String role
) {
    
}

