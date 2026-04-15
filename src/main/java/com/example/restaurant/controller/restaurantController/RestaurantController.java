package com.example.restaurant.controller.restaurantController;

import com.example.restaurant.entity.model.Restaurant;
import com.example.restaurant.entity.dto.ResponseMap;
import com.example.restaurant.entity.dto.ResponseMessage;
import com.example.restaurant.service.restaurantService.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Controller
@RequestMapping("/app/v1")

public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;


    @GetMapping(path = "/restaurant/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseMap<List<Restaurant>> getRestaurantsByCity(@PathVariable String city){
        List<Restaurant> restaurant = restaurantService.findRestorantsByCity(city);

        return new ResponseMap<>(restaurant);
    }

    @PostMapping(path = "/restaurant", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Restaurant saverestaurant(@Valid @RequestBody Restaurant restaurant) {

        return restaurantService.saveRestaurant(restaurant);
    }


    @DeleteMapping(path = "restaurant/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseMessage> deleteRestaurant(@PathVariable @Min(1) Long id){

        restaurantService.deleteRestorantById(id);
        return ResponseEntity.ok().body(new ResponseMessage("Restaurant delete successfully"));

    }



}
