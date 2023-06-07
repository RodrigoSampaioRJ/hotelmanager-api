package com.api.hotelmanager.modules.hotel.dto;

import com.api.hotelmanager.modules.room.entity.Room;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;

@Builder
public record HotelRequest (
		
		@NotBlank(message = "Name must not be empty")
		String name,	
		@NotBlank(message = "Address must not be empty")
		String address,	
		@NotNull(message = "Stars must not be null")
		Integer stars, 
		List<Room> rooms) {}
