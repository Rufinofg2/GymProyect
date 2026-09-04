package com.example.GymProyect.client.repository;

import com.example.GymProyect.client.entity.Cliente;
import org.hibernate.internal.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByDni(String dni);

    boolean existsByDni(String dni);

    Optional<Cliente> findByPhone_number(String phone_number);

    boolean existsByPhone_number(String phone_number);

    List<Cliente> findByNameContainingIgnoreCase(String name);

    List<Cliente> findByLastnameContainingIgnoreCase(String lastname);

    Optional<Cliente> findByUser_Id(Long id);
}
