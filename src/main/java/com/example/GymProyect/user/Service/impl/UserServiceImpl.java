package com.example.GymProyect.user.Service.impl;

import com.example.GymProyect.user.Entity.UserEntity;
import com.example.GymProyect.user.Repository.UserRespository;
import com.example.GymProyect.user.Service.interfaces.UserService;
import com.example.GymProyect.user.UserException.EmailAlreadyExists;
import com.example.GymProyect.user.UserException.UserNotFound;
import com.example.GymProyect.user.dto.Request.UserRequestDTO;
import com.example.GymProyect.user.dto.Response.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRespository userRespository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        if (userRespository.existsByEmail(userRequestDTO.email())){
            throw new EmailAlreadyExists("El email ya existe");
        }
        UserEntity user = UserEntity.builder()
                .email(userRequestDTO.email().toLowerCase())
                .password(passwordEncoder.encode(userRequestDTO.password()))
                .rol(userRequestDTO.rol())
                .isEnabled(true)
                .build();
        UserEntity savedUser = userRespository.save(user);
        return new UserResponseDTO(savedUser.getId(),
                savedUser.getEmail(),
                savedUser.isEnabled(),
                savedUser.getRol(),
                savedUser.getCreated_at(),
                savedUser.getUpdated_at()
        );
    }

    @Override
    public List<UserResponseDTO> obtenerTodos(){
        return userRespository.findAll()
                .stream()
                .map(user -> new UserResponseDTO(user.getId(),
                        user.getEmail(),
                        user.isEnabled(),
                        user.getRol(),
                        user.getCreated_at(),
                        user.getUpdated_at()))
                .collect(Collectors.toList());
    }


    public UserResponseDTO obtenerporID(Long id){
        UserEntity user = userRespository.findById(id).orElseThrow(() -> new UserNotFound("El usuario no existe"));
        return new UserResponseDTO(user.getId(),
                user.getEmail(),
                user.isEnabled(),
                user.getRol(),
                user.getCreated_at(),
                user.getUpdated_at());
    }


    public void eliminarUsuario(Long id){
        if (!userRespository.existsById(id)){
            throw new UserNotFound("El usuario no existe");
        }
        userRespository.deleteById(id);
    }



}
