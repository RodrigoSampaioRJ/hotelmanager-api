package com.api.hotelmanager.dtos;

import com.api.hotelmanager.entities.Profile;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UserRequest(
        @NotBlank
        String name,
        @NotBlank
        String login,
        @NotBlank
        String password,
        @NotBlank
        @Email
        String email,
        Long profile_id) { }
