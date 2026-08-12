package com.example.GymProyect.user.Repository;

import com.example.GymProyect.user.Entity.UserEntity;
import com.example.GymProyect.user.Enums.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRespository extends JpaRepository<UserEntity, Long> {

    //busca por email
    Optional<UserEntity> findByEmail(String email);

    //verifica si existe el email
    boolean existsByEmail(String email);

    //busca por rol
    List<UserEntity> findByRole(Roles role);

    //verifica si el usuario esta activo o  inactivo
    List<UserEntity> findByEnabled(boolean enabled);

    //busca por rol y activo
    List<UserEntity> findByEnabledAndRole(boolean enabled, Roles role);
}
