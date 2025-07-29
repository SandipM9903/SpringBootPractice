package com.sandip.rest.webservices.rest_web_services.controller;

import com.sandip.rest.webservices.rest_web_services.Exceptions.UserNotFoundException;
import com.sandip.rest.webservices.rest_web_services.dao.UserDaoService;
import com.sandip.rest.webservices.rest_web_services.model.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    //Get all user
    @GetMapping("/users")
    public List<User> getAllUser() {
        return userDaoService.findAll();
    }

    //Get User by Id
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id){
        User user = userDaoService.findUserById(id);
        if(user == null){
            throw new UserNotFoundException("User not found by id: " + id);
        }
        return user;
    }

    //Save User
    @PostMapping("users")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
        User savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable int id){
        userDaoService.deleteUser(id);
    }
}
