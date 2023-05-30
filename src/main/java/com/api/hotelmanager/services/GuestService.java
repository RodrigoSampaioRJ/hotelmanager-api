package com.api.hotelmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Autowired
	private final GuestRepository guestRepository;
	
	public GuestResponse getGuest(String id) {	
		GuestResponse guestResponse = mapToGuestResponse(guestRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Guest not found")));
		return guestResponse;
	}

	public Page<GuestResponse> getAllGuests(Pageable pageable){	
		Page<Guest> guestPage = guestRepository.findAll(pageable);	
		Page<GuestResponse> guestResponsePage = guestPage.map(this::mapToGuestResponse);
		return guestResponsePage;
	}
	
	public Guest createGuest(GuestRequest guestRequest) {
		Guest guest = mapToGuest(guestRequest);	
		return guestRepository.save(guest);
	}
	
	private Guest mapToGuest(GuestRequest guestRequest) {
		Guest guest = Guest.builder()
				.name(guestRequest.name())
				.email(guestRequest.email())
				.phone(guestRequest.phone())
				.reservations(guestRequest.reservations())
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
