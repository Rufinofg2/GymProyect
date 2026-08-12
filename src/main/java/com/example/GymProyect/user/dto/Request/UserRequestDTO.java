package com.example.GymProyect.user.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.LocalDate;

@Builder


public record UserRequestDTO(
        @NotBlank(message = "el email es obligatorio")
        @Email
        String email,
        @NotBlank(message = "la contrasena es obligatoria")
        @Size(min = 6)
        String password,

        @NotBlank(message = "El nombre es obligatorio")
        String name,

        @NotBlank(message = "El apellido es obligatorio")
        String lastname,

        @NotBlank(message = "El numero de telefono es obligatorio")
        String phone_number,

        @NotBlank(message = "El dni es obligatorio")
        String dni,

        @NotBlank(message = "La fecha de nacimiento es obligatorio")
        LocalDate date_of_birth
) {}
