package com.example.GymProyect.user.dto.response;



import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserResponseDTO(
      boolean success,
      String message,
      Object data,
      LocalDateTime timestamp
) {}
