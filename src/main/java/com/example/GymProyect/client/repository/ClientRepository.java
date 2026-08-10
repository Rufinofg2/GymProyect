package com.example.GymProyect.client.repository;

import com.example.GymProyect.Entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Cliente, Long> {
}
