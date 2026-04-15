package com.example.restaurant.repository.restaurantRepo;

import com.example.restaurant.entity.model.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

    List<Restaurant> findRestaurantsByCity(String city);



}
