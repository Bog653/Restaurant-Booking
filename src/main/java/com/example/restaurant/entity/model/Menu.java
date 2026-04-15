package com.example.restaurant.entity.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    @NotBlank
    private String name;

    @Column(nullable = false, length = 45)
    @NotBlank
    private String category;

    @Column(nullable = false)
    @NotNull
    private boolean available;

    // define associations
    @ManyToOne
    private Restaurant restaurant;

}
