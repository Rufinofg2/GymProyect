package com.example.GymProyect.attendance.controller;

import com.example.GymProyect.attendance.service.interfaces.AttendanceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/attendance", produces = "application/json")
public class AttendanceController {
    private AttendanceService attendanceService;
}
