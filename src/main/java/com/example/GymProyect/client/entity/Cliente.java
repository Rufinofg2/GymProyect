package com.example.GymProyect.client.entity;

import com.example.GymProyect.assistance.entity.AssitanceEntity;
import com.example.GymProyect.cuota.entity.Cuota;
import com.example.GymProyect.user.Entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Cliente {


    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phone_number;

    @Column(name = "dni", nullable = false, unique = true)
    private String dni;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate date_of_birth;

    // Relación 1:N con Cuota (apunta al atributo 'client' en Cuota.java)
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Cuota> cuotas = new ArrayList<>();

    // Relación 1:N con Asistencia (apunta al atributo 'client' en Asistencia.java)
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<AssitanceEntity> asistencias = new ArrayList<>();



}
