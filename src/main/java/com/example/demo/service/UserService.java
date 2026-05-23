package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional
    public UserResponseDTO criar(UserRequestDTO dto){
        User novoUser = new User();
        novoUser.setEmail(dto.email());
        novoUser.setPassword(dto.password());
        novoUser.setRole(dto.role());
        User salvo = userRepository.save(novoUser);
        return converterEmDTO(salvo);
    }

    public List<UserResponseDTO> listarTodosUsuarios(){
        List<User> usuarios = userRepository.findAll();
        List<UserResponseDTO> usuariosDTO = new ArrayList<>();
        for(User u: usuarios){
            usuariosDTO.add(converterEmDTO(u));
        }
        return usuariosDTO;
    }

    public UserResponseDTO converterEmDTO(User user){
        return new UserResponseDTO (
            user.getId(),
            user.getEmail(),
            user.getPassword(),
            user.getRole()
        );
    }
}
