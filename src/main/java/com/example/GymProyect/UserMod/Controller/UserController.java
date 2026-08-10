package com.example.GymProyect.UserMod.Controller;

import com.example.GymProyect.UserMod.Service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/auth", produces = "application/json")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
}
