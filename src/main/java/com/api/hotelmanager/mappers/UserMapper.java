package com.api.hotelmanager.mappers;

import com.api.hotelmanager.dtos.UserRequest;
import com.api.hotelmanager.dtos.UserResponse;
import com.api.hotelmanager.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(target = "id", ignore = true)
    User userRequestToUser(UserRequest userRequest);
    UserResponse toUserResponse(User user);
}
