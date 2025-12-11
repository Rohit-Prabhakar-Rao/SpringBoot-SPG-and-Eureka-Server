package com.springtesting.user_service.controller;

import com.springtesting.user_service.model.CreateUserDto;
import com.springtesting.user_service.model.User;
import com.springtesting.user_service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserDto dto) {
        // log dto fields
        System.out.println("DEBUG incoming DTO -> username=" + dto.getUsername()
                + " email=" + dto.getEmail() + " role=" + dto.getRole());

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        user.setEmail(dto.getEmail());

        // log user fields before save
        System.out.println("DEBUG mapped User -> username=" + user.getUsername()
                + " email=" + user.getEmail() + " role=" + user.getRole());

        User saved = service.saveUser(user);
        System.out.println("DEBUG saved User id=" + saved.getId());
        return ResponseEntity.ok(saved);
    }



    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return service.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
