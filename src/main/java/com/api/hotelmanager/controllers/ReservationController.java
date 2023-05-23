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

import com.api.hotelmanager.dtos.ReservationRequest;
import com.api.hotelmanager.dtos.ReservationResponse;
import com.api.hotelmanager.entities.Reservation;
import com.api.hotelmanager.services.ReservationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reservation")
@RequiredArgsConstructor
public class ReservationController {

	private final ReservationService reservationService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ReservationResponse> getReservation(@PathVariable Long id){
		ReservationResponse reservationResponse = reservationService.getReservation(id);
		
		return ResponseEntity.ok(reservationResponse);
	}
	
	
	@PostMapping
	public ResponseEntity<Reservation> createReservation(
			@RequestBody
			@Valid
			ReservationRequest reservationRequest,
			UriComponentsBuilder uriComponentsBuilder){
		
		Reservation reservation = reservationService.createReservation(reservationRequest);
		
		URI uri = uriComponentsBuilder
				.path("/api/reservation/{id}")
				.buildAndExpand(reservation.getId()).toUri();
		
		return ResponseEntity.created(uri).body(reservation);
		
	}
}