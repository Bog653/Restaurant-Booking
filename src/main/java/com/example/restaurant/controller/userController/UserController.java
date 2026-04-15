package com.example.restaurant.controller.userController;

import com.example.restaurant.entity.model.User;
import com.example.restaurant.entity.dto.ResponseMessage;
import com.example.restaurant.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;


@Controller
@RequestMapping(value = "/app/v1")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getuserById(@PathVariable @Min(1) Long id){
        User user = userService.getUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> insertUser(@Valid @RequestBody User user){
       User returnuUser = userService.insertUser(user);
       return ResponseEntity.ok().body(returnuUser);
    }

    @DeleteMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseMessage> deleteUser(@Positive @PathVariable Long id){

        ResponseMessage responseMessage = new ResponseMessage("User delete successfully");
        userService.deleteUser(id);
        return ResponseEntity.ok().body(responseMessage);



    }





}
