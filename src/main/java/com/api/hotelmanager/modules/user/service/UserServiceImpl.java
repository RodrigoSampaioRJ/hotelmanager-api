package com.api.hotelmanager.modules.user.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.api.hotelmanager.modules.profile.entity.Profile;
import com.api.hotelmanager.modules.profile.repository.IProfileRepository;
import com.api.hotelmanager.modules.user.dto.UserRequest;
import com.api.hotelmanager.modules.user.dto.UserResponse;
import com.api.hotelmanager.modules.user.entity.User;
import com.api.hotelmanager.modules.user.mapper.UserMapper;
import com.api.hotelmanager.modules.user.repository.IUserRepository;

import jakarta.persistence.EntityNotFoundException;

public class UserServiceImpl implements IUserService {

  private final IUserRepository userRepository;
  private final BCryptPasswordEncoder bcrypt;
  private final IProfileRepository profileRepository;
  private final UserMapper mapper;

  public UserServiceImpl(
    IUserRepository userRepository,
    BCryptPasswordEncoder bcrypt,
    IProfileRepository profileRepository,
    UserMapper mapper
  ) {
    this.userRepository = userRepository;
    this.bcrypt = bcrypt;
    this.profileRepository = profileRepository;
    this.mapper = mapper;
  }

  @Override
  public User save(UserRequest userRequest) {

    Profile profile = profileRepository.findById(userRequest.profile_id())
      .orElseThrow(() -> new EntityNotFoundException("Profile not found"));

    String password = bcrypt.encode(userRequest.password());

    System.out.println(userRequest.profile_id());
    User user = User
      .builder()
      .email(userRequest.email())
      .username(userRequest.username())
      .name(userRequest.name())
      .password(password)
      .build();
  
    user.addProfile(profile);
    user = userRepository.save(user);
    return user;
  }

  @Override
  public Page<UserResponse> findAll(Pageable pageable) {
    return null;
  }

  @Override
  public UserResponse findById(Long id) {
    UserResponse userResponse = mapper.userToUserResponse(userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found")));

    return userResponse;
  }

  @Override
  public void delete(Long id) {
    userRepository.delete(id);
  }
}
