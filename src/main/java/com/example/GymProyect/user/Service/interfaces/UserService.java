package com.example.GymProyect.user.Service.interfaces;

import com.example.GymProyect.user.dto.Request.UserRequestDTO;
import com.example.GymProyect.user.dto.Response.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    
    List<UserResponseDTO> obtenerTodos();

}
