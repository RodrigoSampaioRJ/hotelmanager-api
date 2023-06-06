package com.api.hotelmanager.modules.user.mapper;

import com.api.hotelmanager.modules.user.dto.UserRequest;
import com.api.hotelmanager.modules.user.dto.UserResponse;
import com.api.hotelmanager.modules.user.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR,componentModel = "spring")
@Component
public interface UserMapper {


    @Mapping(target = "id", ignore = true)
    User userRequestToUser(UserRequest userRequest);
    UserResponse toUserResponse(User user);
}
