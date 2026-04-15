package com.example.restaurant.entity.dto.restaurantDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto{

    private Long id;
    private String name;
    private String street;
    private String streetNumber;
    private String city;
}
