package com.api.hotelmanager.dtos;

import java.util.List;

import com.api.hotelmanager.entities.Reservation;

import lombok.Builder;


@Builder
public record GuestRequest (
		String name,
		String email, 
		String phone, 
		List<Reservation> reservations){}
