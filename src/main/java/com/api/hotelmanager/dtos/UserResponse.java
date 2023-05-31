package com.api.hotelmanager.dtos;

import com.api.hotelmanager.entities.Profile;

import java.util.List;

public record UserResponse(
        String name,
        String login,
        List<Profile> profiles,
        String email
) {
}
