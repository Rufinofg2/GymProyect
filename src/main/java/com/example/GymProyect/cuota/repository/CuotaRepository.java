package com.example.GymProyect.cuota.repository;

import com.example.GymProyect.cuota.entity.Cuota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuotaRepository extends JpaRepository<Cuota, String> {
}
