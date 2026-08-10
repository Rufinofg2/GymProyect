package com.example.GymProyect.cuota.entity;

import com.example.GymProyect.client.entity.Cliente;
import com.example.GymProyect.cuota.enums.Status;
import com.example.GymProyect.plan.entity.Plan;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cuota")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Cuota {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plan", nullable = false)
    private Plan plan;


    @Column(name = "fecha_pago", nullable = false)
    private LocalDateTime fechaPago;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDateTime fechaVencimiento;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "metodo_pago", length = 255)
    private String metodoPago;


    @Enumerated(EnumType.STRING)
    @Column(length = 255)
    private Status estado;
}
