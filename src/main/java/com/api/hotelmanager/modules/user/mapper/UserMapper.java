package com.api.hotelmanager.modules.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.api.hotelmanager.modules.user.dto.UserRequest;
import com.api.hotelmanager.modules.user.dto.UserResponse;
import com.api.hotelmanager.modules.user.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "profiles", ignore = true)
    User userRequestToUser(UserRequest userRequest);
    UserResponse userToUserResponse(User user);
}
