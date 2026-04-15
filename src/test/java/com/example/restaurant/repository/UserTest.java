package com.example.restaurant.repository;


import com.example.restaurant.RestaurantApplication;
import com.example.restaurant.entity.model.User;
import com.example.restaurant.repository.userRepo.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("app-test.properties")
@ContextConfiguration(classes = RestaurantApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    private Long id;




    @DisplayName("Save an user")
    @BeforeEach
     void init(){

         User user = User.builder()
                .email("hello@hello.com")
                .name("Marco")
                .surname("Rossi")
                .phoneNum("+39123456789")
                .build();

         User inserUser = userRepository.save(user);
         assertEquals(inserUser, userRepository.save(user), "Problems of insert user DB ");
         id = inserUser.getId();


    }


    @Test
    @DisplayName("Find an user by id")
    public void findUserById(){

        Optional<User> userBd = userRepository.findById(id);


        assert(userBd).isPresent();
    }

    @Test
    @DisplayName("User is not present")
    public void userNotPresentById(){

        assertThrows(NoSuchElementException.class,() -> {
            userRepository.findById(700L).orElseThrow();});
    }

    @Test
    @DisplayName("Remove user")
    public void removeuser(){

        userRepository.deleteById(id);
        Long count = userRepository.count();

        assertSame(0L, count);
    }
}
