package com.api.hotelmanager.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.hotelmanager.dtos.GuestRequest;
import com.api.hotelmanager.dtos.GuestResponse;
import com.api.hotelmanager.entities.Guest;
import com.api.hotelmanager.services.GuestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/guest")
@RequiredArgsConstructor
public class GuestController {

	private final GuestService guestService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<GuestResponse> getGuest(@PathVariable Long id) {
		
		GuestResponse guestResponse = guestService.getGuest(id);
		
		return ResponseEntity.ok(guestResponse);
	}
	
	@PostMapping
	public ResponseEntity<Guest> createGuest(
			@RequestBody GuestRequest guestRequest,
			UriComponentsBuilder uriComponentsBuilder) {
		
		Guest guest = guestService.createGuest(guestRequest);
		
		URI uri = uriComponentsBuilder.path("api/guest/{id}")
				.buildAndExpand(guest.getId()).toUri();
		
		
		return ResponseEntity.created(uri).body(guest);
	}
}
