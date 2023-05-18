package com.api.hotelmanager.dtos;

import java.util.List;

import com.api.hotelmanager.entities.Room;

import lombok.Builder;

@Builder
public record HotelRequest (String name, String address, Integer stars, List<Room> rooms) {}
