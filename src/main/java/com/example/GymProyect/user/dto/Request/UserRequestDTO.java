package com.example.GymProyect.user.dto.Request;

import com.example.GymProyect.user.Enums.Roles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder


public record UserRequestDTO(
        @NotBlank(message = "el email es obligatorio") @Email String email,
        @NotBlank(message = "la contrasena es obligatoria") @Size(min = 6) String password,
        Roles rol
) {}
