package com.example.GymProyect.assistance.controller;

import com.example.GymProyect.assistance.service.interfaces.AssistanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/assistance", produces = "application/json")
@RequiredArgsConstructor
public class AssistanceController {
    private AssistanceService assistanceService;
}
