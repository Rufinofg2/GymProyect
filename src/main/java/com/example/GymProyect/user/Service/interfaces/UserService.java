package com.example.GymProyect.user.Service.interfaces;



import com.example.GymProyect.user.dto.request.UserRequestDTO;
import com.example.GymProyect.user.dto.response.UserResponse;
import com.example.GymProyect.user.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    
    List<UserResponse> obtenerTodos();

}
