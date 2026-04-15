package com.example.restaurant.repository.menuRepo;

import com.example.restaurant.entity.model.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepo extends CrudRepository<Menu, Long> {

    List<Menu> findMenuRestaurantById(Long idRestaurant);


}
