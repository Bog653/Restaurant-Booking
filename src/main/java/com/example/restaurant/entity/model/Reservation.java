package com.example.restaurant.entity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "reservation")
// Hibernate/Jpa docs says used java.time* package for Date and Time

public class Reservation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private LocalDate reserveDate;

    @Column(nullable = false)
    @NotBlank
    private LocalTime reserveAt;

    @Column(nullable = false)
    @NotNull
    private int numberPeople;

    // now define Associations
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;


}
