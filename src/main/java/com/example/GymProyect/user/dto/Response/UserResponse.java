package com.example.GymProyect.user.dto.response;

import com.example.GymProyect.client.dto.response.ClientResponse;

import com.example.GymProyect.user.Enums.Roles;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserResponse(
        Long id,
        String email,
        boolean enabled,
        Roles rol,
        ClientResponse client,
        LocalDateTime created_at,
        LocalDateTime updated_at
) {
}
