package com.example.GymProyect.UserMod.Repository;

import com.example.GymProyect.UserMod.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<UserEntity, Long> {
}
