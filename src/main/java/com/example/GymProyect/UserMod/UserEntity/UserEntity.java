package com.example.GymProyect.UserMod.UserEntity;

import com.example.GymProyect.UserMod.Enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false)
    private String Name;

    @Column (nullable = false)
    private String LastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column (nullable = false)
    private String password;

    @Column (nullable = false, unique = true)
    private String celphone;

    @Column (nullable = false, unique = true)
    private String dni;

    @Column (nullable = false)
    private Roles rol;

}
