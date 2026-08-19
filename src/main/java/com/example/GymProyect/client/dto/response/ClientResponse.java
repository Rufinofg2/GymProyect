package com.example.GymProyect.client.dto.response;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ClientResponse(
        String name,
        String lastname,
        String dni,
        String phone_number,
        LocalDate date_of_birth
) {
}
