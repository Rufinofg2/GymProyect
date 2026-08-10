package com.example.GymProyect.assistance.entity;


import com.example.GymProyect.client.entity.Cliente;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "assistance")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssitanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha",nullable = false)
    private LocalDateTime fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;


}
