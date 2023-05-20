package com.api.hotelmanager.controllers;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.hotelmanager.dtos.HotelRequest;
import com.api.hotelmanager.dtos.HotelResponse;
import com.api.hotelmanager.entities.Hotel;
import com.api.hotelmanager.services.HotelService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/hotel")
@RequiredArgsConstructor
public class HotelController {
	
	private final HotelService hotelService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<HotelResponse> getHotel(@PathVariable Long id) {
		HotelResponse hotelResponse = hotelService.getHotel(id);
		return ResponseEntity.ok(hotelResponse);
	}
	
	@GetMapping
	public ResponseEntity<Page<HotelResponse>> getAll(Pageable page){
		Page<HotelResponse> hotelResponsePage = hotelService.getAll(page);
		return ResponseEntity.ok(hotelResponsePage);
	}
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(
			@RequestBody 
			@Valid
			HotelRequest hotelRequest,
			UriComponentsBuilder uriComponentsBuilder) {
		Hotel hotel = hotelService.createHotel(hotelRequest);
		URI uri = uriComponentsBuilder
				.path("/api/hotel/{id}")
				.buildAndExpand(hotel
						.getId())
				.toUri();
		return ResponseEntity.created(uri).body(hotel);
	}

}
