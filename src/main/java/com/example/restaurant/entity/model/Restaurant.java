package com.example.restaurant.entity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "restaurant")

public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    @NotBlank
    private String name;

    @Column(nullable = false, length = 20)
    @NotBlank
    private String phoneNum;

    @Column(nullable = false)
    @NotNull
    private int peopleCapacity;

    @Column(nullable = false, length = 45)
    @NotBlank
    private String street;

    @Column(nullable = false, length = 45)
    @NotBlank
    private String zipCode;
    @Column(nullable = false, length = 45)
    @NotBlank
    private String streetNumber;
    @Column(nullable = false, length = 45)
    @NotBlank
    private String city;

    // define Associations
    @OneToMany(mappedBy = "restaurant", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

    // if i remove a restaurant, remove (cascade) menus
    @OneToMany(mappedBy = "restaurant", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    private List<Menu> menus = new ArrayList<>();


}
