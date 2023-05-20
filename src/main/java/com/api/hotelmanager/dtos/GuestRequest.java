package com.api.hotelmanager.dtos;

import java.util.List;

import com.api.hotelmanager.entities.Reservation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;


@Builder
public record GuestRequest (
		
		@NotBlank(message = "Name must not be empty")
		String name,	
		@NotBlank(message = "Email must not be empty")
		@Email(message = "Email is invalid")
		String email,	
		@NotBlank(message = "Phone must not be empty")
		String phone, 
		List<Reservation> reservations){}
