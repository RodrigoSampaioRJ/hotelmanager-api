package com.api.hotelmanager.modules.user.mapper;

import org.mapstruct.Mapper;

import com.api.hotelmanager.modules.user.dto.UserRequest;
import com.api.hotelmanager.modules.user.dto.UserResponse;
import com.api.hotelmanager.modules.user.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    

    User userRequestToUser(UserRequest userRequest);
    UserResponse userToUserResponse(User user);
}
