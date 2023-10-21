package com.api.hotelmanager.modules.hotel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.api.hotelmanager.modules.hotel.dto.HotelRequest;
import com.api.hotelmanager.modules.hotel.dto.HotelResponse;
import com.api.hotelmanager.modules.hotel.entity.Hotel;

@Mapper(componentModel = "spring")
public interface HotelMapper {
    
    
    HotelResponse hotelTHotelResponse(Hotel hotel);
    
    @Mapping(target = "id", ignore = true)
    Hotel hotelRequestToHotel(HotelRequest hotelRequest);
}
