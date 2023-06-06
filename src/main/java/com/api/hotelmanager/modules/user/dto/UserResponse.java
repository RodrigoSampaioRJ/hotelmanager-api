package com.api.hotelmanager.modules.user.dto;

import com.api.hotelmanager.modules.profile.entity.Profile;

import java.util.List;

public record UserResponse(
        String name,
        String login,
        List<Profile> profiles,
        String email
) {
}
