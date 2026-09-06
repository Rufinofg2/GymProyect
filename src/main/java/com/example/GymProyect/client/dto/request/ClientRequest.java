package com.example.GymProyect.client.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


public record ClientRequest(
        @NotBlank(message = "el nombre es obligatorio")
        @Size(min = 3)
        String name,

        @NotBlank(message = "el apellido es obligatorio")
        @Size(min = 3)
        String lastname,

        @NotBlank(message = "el dni es obligatorio")
        @Size(min = 8)
        String dni,

        @NotBlank(message = "el numero de telefono es obligatorio")
        @Size(min = 8)
        String phoneNumber,

        @NotNull(message = "fecha de nacimiento obligatoria")
        LocalDate dateOfBirth

) {
}
