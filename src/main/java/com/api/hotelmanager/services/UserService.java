package com.api.hotelmanager.services;

import com.api.hotelmanager.dtos.UserRequest;
import com.api.hotelmanager.dtos.UserResponse;
import com.api.hotelmanager.entities.Profile;
import com.api.hotelmanager.entities.User;
import com.api.hotelmanager.mappers.UserMapper;
import com.api.hotelmanager.repositories.ProfileRepository;
import com.api.hotelmanager.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final BCryptPasswordEncoder bcrypt;
    private final ProfileRepository profileRepository;


    public User createUser(UserRequest userRequest) {
        Profile profile = profileRepository.findById(userRequest.profile_id()).orElseThrow(() -> new EntityNotFoundException("Profile not found"));
        String password = bcrypt.encode(userRequest.password());
        User user = User.builder()
                .email(userRequest.email())
                .login(userRequest.login())
                .name(userRequest.name())
                .password(password)
                .build();
        user.addProfile(profile);
        return userRepository.save(user);
    }

    public UserResponse getUser(Long id) {
       UserResponse userResponse = mapper
               .toUserResponse(userRepository
                       .findById(id)
                       .orElseThrow(() -> new EntityNotFoundException("User not found")));
            return userResponse;

    }
}
