package com.api.hotelmanager.modules.user.service;

import com.api.hotelmanager.modules.user.dto.UserRequest;
import com.api.hotelmanager.modules.user.dto.UserResponse;
import com.api.hotelmanager.modules.profile.entity.Profile;
import com.api.hotelmanager.modules.user.entity.User;
import com.api.hotelmanager.modules.user.mapper.UserMapper;
import com.api.hotelmanager.modules.profile.repository.ProfileRepository;
import com.api.hotelmanager.modules.user.repository.IUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final UserMapper mapper;
    private final BCryptPasswordEncoder bcrypt;
    private final ProfileRepository profileRepository;

    public UserServiceImpl(IUserRepository userRepository, UserMapper mapper, BCryptPasswordEncoder bcrypt, ProfileRepository profileRepository){
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.bcrypt = bcrypt;
        this.profileRepository = profileRepository;
    }

    @Override
    public User save(UserRequest userRequest) {
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

    @Override
    public Page<UserResponse> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public UserResponse findById(Long id) {
        UserResponse userResponse = mapper
                .toUserResponse(userRepository
                        .findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("User not found")));
        return userResponse;
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
