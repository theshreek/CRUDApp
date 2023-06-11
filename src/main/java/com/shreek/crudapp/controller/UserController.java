package com.shreek.crudapp.controller;

import com.shreek.crudapp.dto.ResponseDTO;
import com.shreek.crudapp.dto.UserDTO;
import com.shreek.crudapp.model.User;
import com.shreek.crudapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Method to create new user
     */
    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        return userService.create(user);
    }

    // Controller to update old user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable int id, @RequestBody User user) {
        return userService.updateUserById(id, user);
    }

    // Controller to delete existing user
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteUserById(@PathVariable int id) {
        return userService.deleteUserById(id);
    }

    // Controller to get all user
    @GetMapping
    public List<UserDTO> getAllUser() {
        return userService.getAllUsers();
    }

    // Controller to get user by id
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }
}