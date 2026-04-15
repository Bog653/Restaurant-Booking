package com.example.restaurant.entity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    @NotBlank
    private String name;

    @Column(nullable = false, length = 45)
    @NotBlank
    private String surname;

    @Column(nullable = false, length = 80, unique = true)
    @NotBlank
    private String email;

    @Column(nullable = false, length = 20)
    @NotBlank
    private String phoneNum;

    // Define bi- directional associations with Reservation entity
    // In this case mapped the name of variable ( attribute ) in Reservation class.
    @OneToMany(mappedBy = "user")
     private List<Reservation> reservation = new ArrayList<>();

}
