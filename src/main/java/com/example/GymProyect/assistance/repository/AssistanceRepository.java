package com.example.GymProyect.assistance.repository;

import com.example.GymProyect.assistance.entity.AssitanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistanceRepository extends JpaRepository<AssitanceEntity, Long> {
}
