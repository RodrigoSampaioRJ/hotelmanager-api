package com.api.hotelmanager.modules.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @NotBlank
        String name,
        @NotBlank
        String username,
        @NotBlank
        String password,
        @NotBlank
        @Email
        String email,
        Long profile_id ) { }
