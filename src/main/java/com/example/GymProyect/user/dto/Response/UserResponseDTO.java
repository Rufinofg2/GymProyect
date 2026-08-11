package com.example.GymProyect.user.dto.Response;

import com.example.GymProyect.user.Enums.Roles;

import java.time.LocalDateTime;

public record UserResponseDTO(
        Long Id,
        String email,
        boolean enabled,
        Roles rol,
        LocalDateTime createdAt,
        LocalDateTime updeateAT
) {}
