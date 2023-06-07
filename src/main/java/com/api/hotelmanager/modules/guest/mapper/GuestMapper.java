package com.api.hotelmanager.modules.guest.mapper;

import com.api.hotelmanager.modules.guest.dto.GuestRequest;
import com.api.hotelmanager.modules.guest.dto.GuestResponse;
import com.api.hotelmanager.modules.guest.entity.Guest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface GuestMapper {

    @Mapping(target = "id", ignore = true)
    Guest mapToGuest(GuestRequest guestRequest);
    GuestResponse mapToGuestResponse(Guest guest);
}
