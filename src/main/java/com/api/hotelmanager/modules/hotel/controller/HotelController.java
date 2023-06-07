package com.api.hotelmanager.modules.hotel.controller;

import com.api.hotelmanager.modules.hotel.dto.HotelRequest;
import com.api.hotelmanager.modules.hotel.dto.HotelResponse;
import com.api.hotelmanager.modules.hotel.entity.Hotel;
import com.api.hotelmanager.modules.hotel.service.HotelServiceImpl;
import com.api.hotelmanager.modules.hotel.service.IHotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/hotel")
public class HotelController {

	private final IHotelService hotelService;

	public HotelController(IHotelService hotelService) {
		this.hotelService = hotelService;
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<HotelResponse> getHotel(@PathVariable Long id) {
		HotelResponse hotelResponse = hotelService.findById(id);
		return ResponseEntity.ok(hotelResponse);
	}
	
	@GetMapping
	public ResponseEntity<Page<HotelResponse>> getAll(Pageable page){
		Page<HotelResponse> hotelResponsePage = hotelService.findAll(page);

		return ResponseEntity.ok(hotelResponsePage);
	}
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(
			@RequestBody 
			@Valid
			HotelRequest hotelRequest,
			UriComponentsBuilder uriComponentsBuilder) {
		Hotel hotel = hotelService.save(hotelRequest);
		URI uri = uriComponentsBuilder
				.path("/api/hotel/{id}")
				.buildAndExpand(hotel.getId())
				.toUri();
		return ResponseEntity.created(uri).body(hotel);
	}

}
