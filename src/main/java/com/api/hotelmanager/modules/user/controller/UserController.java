package com.api.hotelmanager.modules.user.controller;

import com.api.hotelmanager.modules.user.dto.UserRequest;
import com.api.hotelmanager.modules.user.dto.UserResponse;
import com.api.hotelmanager.modules.user.entity.User;
import com.api.hotelmanager.modules.user.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private final IUserService userService;

    public UserController(final IUserService userService){
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserRequest userRequest, UriComponentsBuilder uriComponentsBuilder) {
        User user = userService.save(userRequest);
        URI uri = uriComponentsBuilder
                .path("/api/user/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
