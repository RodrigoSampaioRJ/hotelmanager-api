package com.api.hotelmanager.dtos;

import java.util.List;

import com.api.hotelmanager.entities.Reservation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GuestRequest {
	
	private String name;
	private String email;
	private String phone;

	@Singular
	private List<Reservation> reservations;

}
