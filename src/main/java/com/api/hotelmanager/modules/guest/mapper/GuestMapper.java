package com.api.hotelmanager.modules.guest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.api.hotelmanager.modules.guest.dto.GuestRequest;
import com.api.hotelmanager.modules.guest.dto.GuestResponse;
import com.api.hotelmanager.modules.guest.entity.Guest;

@Mapper(componentModel = "spring")
public interface GuestMapper {
    
    GuestResponse guestToGuestResponse(Guest guest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    Guest guestRequestToGuest(GuestRequest guestRequest);
}
