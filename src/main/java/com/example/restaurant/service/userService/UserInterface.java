package com.example.restaurant.service.userService;

import com.example.restaurant.entity.model.User;

public interface UserInterface {

    User getUserById(Long id);
    User insertUser(User user);
    void deleteUser(Long id);

}
