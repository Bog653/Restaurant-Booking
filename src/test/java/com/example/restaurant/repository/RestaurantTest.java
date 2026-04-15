package com.example.restaurant.repository;
import com.example.restaurant.entity.model.Restaurant;
import com.example.restaurant.repository.restaurantRepo.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("app-test.properties")
public class RestaurantTest {

    @Autowired
    private RestaurantRepository repository;

    private String city = "Roma";

    private Long id;


    @BeforeEach
    void init(){

        Restaurant insert = Restaurant.builder()
                .city("Roma")
                .name("Cracco")
                .phoneNum("123456789")
                .peopleCapacity(250)
                .street("via Milano")
                .streetNumber("10")
                .zipCode("00123")
                .build();
       Restaurant restaurant = repository.save(insert);
       id = restaurant.getId();
    }


   @Test
   void findRestaurantById(){

       Optional<Restaurant> restaurant = repository.findById(id);

       assert(restaurant).isPresent();

    }


    @Test
    void findRestaurantByCity(){

        List<Restaurant> restaurant = repository.findRestaurantsByCity(city);

        assertFalse(restaurant.isEmpty());

    }

}
