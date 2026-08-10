package com.example.GymProyect.client.controller;

import com.example.GymProyect.client.service.interfaces.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/client", produces = "application/json")
@RequiredArgsConstructor
public class ClientController {
//wasa
    private ClientService clientService;
}
