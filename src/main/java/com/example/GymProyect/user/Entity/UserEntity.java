package com.example.GymProyect.user.Entity;

import com.example.GymProyect.client.entity.Cliente;
import com.example.GymProyect.user.Enums.Roles;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "`user`")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Cliente cliente;

    @Column(name = "email",nullable = false, unique = true)
    private String email;

    @Column (name = "password",nullable = false)
    private String password;

    @Column(name = "isEnabled", nullable = false)
    private boolean isEnabled;


    @Enumerated(EnumType.STRING)
    @Column (name = "role",nullable = false)
    private Roles rol;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;


    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updated_at;


    @PrePersist
    private void onCreate() {
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }


    @PreUpdate
    private void onUpdate(){
        this.updated_at = LocalDateTime.now();
    }

}
