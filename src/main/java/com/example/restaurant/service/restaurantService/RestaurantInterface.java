package com.example.restaurant.service.restaurantService;

import com.example.restaurant.entity.model.Restaurant;

import java.util.List;

public interface RestaurantInterface {

    Restaurant saveRestaurant(Restaurant restaurant);

    List<Restaurant> findRestorantsByCity(String city);

    void deleteRestorantById(Long id);


}
