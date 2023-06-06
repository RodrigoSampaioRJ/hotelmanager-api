package com.api.hotelmanager.modules.hotel.dto;

import java.util.List;

import com.api.hotelmanager.modules.room.entity.Room;

import lombok.Builder;

@Builder
public record HotelResponse (Long id, String name, String address, Integer stars, List<Room> rooms){}
