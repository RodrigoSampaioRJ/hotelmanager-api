package com.api.hotelmanager.modules.hotel.mapper;

import com.api.hotelmanager.modules.hotel.dto.HotelRequest;
import com.api.hotelmanager.modules.hotel.dto.HotelResponse;
import com.api.hotelmanager.modules.hotel.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "Spring")
@Component
public interface HotelMapper {

    @Mapping(target = "id", ignore = true)
    Hotel mapToHotel(HotelRequest hotelRequest);
    HotelResponse mapToHotelResponse(Hotel hotel);
}
