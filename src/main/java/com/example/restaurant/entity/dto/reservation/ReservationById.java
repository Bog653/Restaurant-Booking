package com.example.restaurant.entity.dto.reservation;

import com.example.restaurant.entity.dto.restaurantDto.RestaurantDto;
import com.example.restaurant.entity.dto.userDto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationById {

    private Long id;
    private LocalDate reserveDate;
    private LocalTime reserveAt;
    private int numberPeople;
    private UserDto userDto;
    private RestaurantDto restaurantDto;
}
