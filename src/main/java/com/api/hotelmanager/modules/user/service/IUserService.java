package com.api.hotelmanager.modules.user.service;

import com.api.hotelmanager.modules.user.dto.UserRequest;
import com.api.hotelmanager.modules.user.dto.UserResponse;
import com.api.hotelmanager.modules.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    User save(UserRequest userRequest);
    Page<UserResponse>findAll(Pageable pageable);
    UserResponse findById(Long id);
    void delete(Long id);
}
