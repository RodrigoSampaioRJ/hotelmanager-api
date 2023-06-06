package com.api.hotelmanager.modules.hotel.dto;

import java.util.List;

import com.api.hotelmanager.modules.room.entity.Room;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record HotelRequest (
		
		@NotBlank(message = "Name must not be empty")
		String name,	
		@NotBlank(message = "Address must not be empty")
		String address,	
		@NotNull(message = "Stars must not be null")
		Integer stars, 
		List<Room> rooms) {}
