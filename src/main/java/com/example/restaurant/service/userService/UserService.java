package com.example.restaurant.service.userService;


import com.example.restaurant.entity.model.User;
import com.example.restaurant.repository.userRepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserInterface{

    @Autowired
    private UserRepository userRepository;


    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);

        return user.orElseThrow();
    }

    @Override
    public User insertUser(User user) {
        return userRepository.save(user);

    }

    @Override
    public void deleteUser(Long id) {

        userRepository.deleteById(id);
    }
}
