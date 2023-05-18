package com.api.hotelmanager.dtos;

import java.util.List;

import com.api.hotelmanager.entities.Room;

import lombok.Builder;

@Builder
public record HotelResponse (String name, String address, String stars, List<Room> rooms){}
