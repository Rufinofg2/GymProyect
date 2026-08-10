package com.example.GymProyect.plan.entity;

import com.example.GymProyect.cuota.entity.Cuota;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "plan")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "days_week")
    private Integer daysWeek;

    @Column(name = "duracion_dias", nullable = false)
    private int durationDays;


    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @OneToMany(mappedBy = "plan")
    @Builder.Default
    private List<Cuota> cuotas = new ArrayList<>();
}
