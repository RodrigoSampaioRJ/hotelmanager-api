package com.api.hotelmanager.modules.room.dto;

import com.api.hotelmanager.modules.hotel.entity.Hotel;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
