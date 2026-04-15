package com.example.restaurant.service.restaurantService;

import com.example.restaurant.entity.model.Restaurant;
import com.example.restaurant.repository.restaurantRepo.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService implements RestaurantInterface {

    @Autowired
    private RestaurantRepository repository;


    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    @Override
    public List<Restaurant> findRestorantsByCity(String city) {
        return repository.findRestaurantsByCity(city);
    }

    @Override
    public void deleteRestorantById(Long id) {
          repository.deleteById(id);
    }
}
