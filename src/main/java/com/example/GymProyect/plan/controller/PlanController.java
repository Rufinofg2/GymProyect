package com.example.GymProyect.plan.controller;

import com.example.GymProyect.plan.service.interfaces.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/plan/", produces = "application/json")
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;
}
