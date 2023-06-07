package com.api.hotelmanager.modules.hotel.dto;

import com.api.hotelmanager.modules.room.entity.Room;
import lombok.Builder;

import java.util.List;

@Builder
public record HotelResponse (Long id, String name, String address, Integer stars, List<Room> rooms){}
