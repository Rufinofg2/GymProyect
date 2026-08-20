package com.example.GymProyect.user.Service.impl;

import com.example.GymProyect.client.dto.response.ClientResponse;
import com.example.GymProyect.client.entity.Cliente;
import com.example.GymProyect.user.Entity.UserEntity;
import com.example.GymProyect.user.Enums.Roles;
import com.example.GymProyect.user.Repository.UserRespository;
import com.example.GymProyect.user.Service.interfaces.UserService;
import com.example.GymProyect.user.UserException.EmailAlreadyExists;
import com.example.GymProyect.user.UserException.UserNotFound;
import com.example.GymProyect.user.dto.response.UserResponse;
import com.example.GymProyect.user.dto.response.UserResponseDTO;
import com.example.GymProyect.user.dto.request.UserRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

        Cliente newClient = Cliente.builder()
                .name(userRequestDTO.name())
                .lastname(userRequestDTO.lastname())
                .dni(userRequestDTO.dni())
                .phone_number(userRequestDTO.phone_number())
                .date_of_birth(userRequestDTO.date_of_birth())
                .build();

        UserEntity user = UserEntity.builder()
                .email(userRequestDTO.email().toLowerCase())
                .password(passwordEncoder.encode(userRequestDTO.password()))
                .role(Roles.CLIENT)
                .cliente(newClient)
                .isEnabled(false)
                .build();


        newClient.setUser(user);

        UserEntity savedUser = userRespository.save(user);


        return UserResponseDTO.builder()
                .success(true)
                .message("Registro completado con exito, por favor verifica su correo electronico para activar su cuenta")
                .data(UserResponse.builder()
                        .id(savedUser.getId())
                        .email(savedUser.getEmail())
                        .enabled(savedUser.isEnabled())
                        .rol(savedUser.getRole())
                        .client(ClientResponse.builder()
                                .name(newClient.getName())
                                .lastname(newClient.getLastname())
                                .dni(newClient.getDni())
                                .phone_number(newClient.getPhone_number())
                                .date_of_birth(newClient.getDate_of_birth()).build())
                        .created_at(savedUser.getCreated_at())
                        .build()
                        )
                .timestamp(LocalDateTime.now())
                .build();

    }

    @Override
    public UserResponseDTO obtenerPorId(Long id){
        UserEntity userEntity = userRespository.findById(id)
                .orElseThrow(() -> new UserNotFound("No se encontro el usuario con el id: " + id + ""));

        return UserResponseDTO.builder()
                .success(true)
                .message("Usuario Encontrado")
                .data(UserResponse.builder()
                        .id(userEntity.getId())
                        .email(userEntity.getEmail())
                        .enabled(userEntity.isEnabled())
                        .rol(userEntity.getRole())
                        .client(ClientResponse.builder()
                                .name(userEntity.getCliente().getName())
                                .lastname(userEntity.getCliente().getLastname())
                                .dni(userEntity.getCliente().getDni())
                                .phone_number(userEntity.getCliente().getPhone_number())
                                .date_of_birth(userEntity.getCliente().getDate_of_birth())
                                .build())
                        .created_at(userEntity.getCreated_at())
                        .updated_at(userEntity.getUpdated_at())
                        .build())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @Override
    public void eliminarPorId(Long id){
        if (!userRespository.existsById(id)){
            throw new UserNotFound("No se encontro el usuario con el id: " + id + "");
        }
        userRespository.deleteById(id);
    }

    @Override
    public void desahibilitarUsuario(Long id){
        UserEntity userEntity = userRespository.findById(id)
                .orElseThrow(() -> new UserNotFound("No se encontro el usuario con el id: " + id + ""));
        userEntity.setEnabled(false);
        userRespository.save(userEntity);
    }

    @Override
    public List<UserResponse> obtenerTodos(){
        return userRespository.findAll()
                .stream()
                .map(userEntity -> UserResponse.builder()
                        .id(userEntity.getId())
                        .email(userEntity.getEmail())
                        .enabled(userEntity.isEnabled())
                        .client(ClientResponse.builder()
                                .name(userEntity.getCliente().getName())
                                .lastname(userEntity.getCliente().getLastname())
                                .dni(userEntity.getCliente().getDni())
                                .phone_number(userEntity.getCliente().getPhone_number())
                                .date_of_birth(userEntity.getCliente().getDate_of_birth())
                                .build())
                        .rol(userEntity.getRole())
                        .created_at(userEntity.getCreated_at())
                        .updated_at(userEntity.getUpdated_at())
                        .build())
                .collect(Collectors.toList());
    }




}
