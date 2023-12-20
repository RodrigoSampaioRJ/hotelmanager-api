package com.api.hotelmanager.modules.guest.controller;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.hotelmanager.modules.guest.dto.GuestRequest;
import com.api.hotelmanager.modules.guest.dto.GuestResponse;
import com.api.hotelmanager.modules.guest.entity.Guest;
import com.api.hotelmanager.modules.guest.service.IGuestService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(value = "/api/guest")
public class GuestController {

	private final IGuestService guestService;

	public GuestController(IGuestService guestService){
		this.guestService = guestService;
	}
	
	@GetMapping
	public ResponseEntity<Page<GuestResponse>> getAllGuests(Pageable pageable){
		return ResponseEntity.ok(guestService.findAll(pageable));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<GuestResponse> getGuest(@PathVariable Long id) {
		GuestResponse guestResponse = guestService.findById(id);
		return ResponseEntity.ok(guestResponse);
	}
	
	@PostMapping
	public ResponseEntity<Guest> createGuest(
			@RequestBody 
			@Valid 
			GuestRequest guestRequest,
			UriComponentsBuilder uriComponentsBuilder) {
		
		Guest guest = guestService.save(guestRequest);
		URI uri = uriComponentsBuilder.path("api/guest/{id}")
				.buildAndExpand(guest.getId()).toUri();
		return ResponseEntity.created(uri).body(guest);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deleteGuest(@PathVariable Long id){
		guestService.delete(id);
		return ResponseEntity.ok(null);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<GuestResponse> updateGuest(@PathVariable Long id, @RequestBody @Valid GuestRequest guestRequest) {
		GuestResponse guestResponse = guestService.update(id, guestRequest);	
		return ResponseEntity.ok().body(guestResponse);
	}
}
