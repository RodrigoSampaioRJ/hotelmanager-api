package com.api.hotelmanager.services;

import org.springframework.stereotype.Service;

import com.api.hotelmanager.dtos.GuestRequest;
import com.api.hotelmanager.dtos.GuestResponse;
import com.api.hotelmanager.entities.Guest;
import com.api.hotelmanager.repositories.GuestRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GuestService {

	private final GuestRepository guestRepository;
	
	public GuestResponse getGuest(Long id) {
		
		GuestResponse guestResponse = mapToGuestResponse(guestRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Guest not found")));
		
		return guestResponse;
	}
	
	public Guest createGuest(GuestRequest guestRequest) {
		
		Guest guest = mapToGuest(guestRequest);
		
		return guestRepository.save(guest);
	}
	
	private Guest mapToGuest(GuestRequest guestRequest) {
		
		Guest guest = Guest.builder()
				.name(guestRequest.getName())
				.email(guestRequest.getEmail())
				.phone(guestRequest.getPhone())
				.reservations(guestRequest.getReservations())
				.build();
		
		return guest;
	}
	
	private GuestResponse mapToGuestResponse(Guest guest) {
		
		GuestResponse guestResponse = GuestResponse.builder()
				.name(guest.getName())
				.email(guest.getEmail())
				.phone(guest.getPhone())
				.build();
		
		return guestResponse;
		
	}
}
