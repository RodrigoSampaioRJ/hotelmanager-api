package com.api.hotelmanager.dtos;

import com.api.hotelmanager.entities.Hotel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record RoomRequest(
		
		@NotNull
		Integer number,
		@NotBlank
		String type,
		@NotNull
		Double price,
		Hotel hotel) {

}
