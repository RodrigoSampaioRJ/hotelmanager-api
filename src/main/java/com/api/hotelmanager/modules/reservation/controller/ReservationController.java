package com.api.hotelmanager.modules.reservation.controller;

import com.api.hotelmanager.modules.reservation.dto.ReservationRequest;
import com.api.hotelmanager.modules.reservation.dto.ReservationResponse;
import com.api.hotelmanager.modules.reservation.entity.Reservation;
import com.api.hotelmanager.modules.reservation.service.IReservationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

	private final IReservationService reservationService;

	public ReservationController(IReservationService reservationService) {
		this.reservationService = reservationService;
	}


	@GetMapping("/{id}")
	public ResponseEntity<ReservationResponse> getReservation(@PathVariable Long id){
		ReservationResponse reservationResponse = reservationService.findById(id);
		return ResponseEntity.ok(reservationResponse);
	}
	
	
	@PostMapping
	public ResponseEntity<Reservation> createReservation(
			@RequestBody
			@Valid
			ReservationRequest reservationRequest,
			UriComponentsBuilder uriComponentsBuilder){
		
		Reservation reservation = reservationService.save(reservationRequest);
		
		URI uri = uriComponentsBuilder
				.path("/api/reservation/{id}")
				.buildAndExpand(reservation.getId()).toUri();
		
		return ResponseEntity.created(uri).body(reservation);
		
	}
}
