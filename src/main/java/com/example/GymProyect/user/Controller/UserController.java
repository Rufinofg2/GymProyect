package com.example.GymProyect.user.Controller;

import com.example.GymProyect.user.Service.interfaces.UserService;
import com.example.GymProyect.user.dto.request.UserRequestDTO;
import com.example.GymProyect.user.dto.response.UserResponse;
import com.example.GymProyect.user.dto.response.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/auth", produces = "application/json")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;



    @PostMapping("/signin")
    public ResponseEntity<UserResponseDTO> singin (@RequestBody UserRequestDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.createUser(request));
    }


    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.obtenerTodos());
    }
}
