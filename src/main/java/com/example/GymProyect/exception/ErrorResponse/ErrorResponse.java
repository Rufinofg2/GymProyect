package com.example.GymProyect.exception.ErrorResponse;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private int status;
    private String error;       // Ej: "Bad Request", "Unauthorized"
    private String message;     // El mensaje para el usuario
    private String path;        // El endpoint que falló (ej: /api/v1/publications)
    private LocalDateTime timestamp;

    // Para cuando haya múltiples errores (como formularios de validación)
    private Map<String, String> errors;
}
