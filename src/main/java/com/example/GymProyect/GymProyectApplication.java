package com.example.GymProyect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Entry point for the GymProyect Spring Boot application.
 */
@SpringBootApplication
@EnableScheduling
public class GymProyectApplication {

  public static void main(String[] args) {
    SpringApplication.run(GymProyectApplication.class, args);
  }
}
