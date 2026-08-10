package com.example.GymProyect.client.entity;

import com.example.GymProyect.user.Entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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

    @Column(name = "dni", nullable = false,unique = true)
    private String dni;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDateTime date_of_birth;




}
