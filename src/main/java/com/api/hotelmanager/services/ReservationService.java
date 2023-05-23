package com.api.hotelmanager.services;

import org.springframework.stereotype.Service;

import com.api.hotelmanager.dtos.ReservationRequest;
import com.api.hotelmanager.dtos.ReservationResponse;
import com.api.hotelmanager.entities.Reservation;
import com.api.hotelmanager.mappers.ReservationMapper;
import com.api.hotelmanager.repositories.ReservationRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {

	private final ReservationRepository reservationRepository;
	private final ReservationMapper mapper;

	public Reservation createReservation(ReservationRequest reservationRequest) {
		Reservation reservation = reservationRepository
				.save(mapper.reservationRequestToReservation(reservationRequest));
		return reservation;
	}

	public ReservationResponse getReservation(Long id) {
		ReservationResponse reservationResponse = 
				mapper.reservationToReservationResponse(
						reservationRepository
						.findById(id)
						.orElseThrow(() -> new EntityNotFoundException("Reservation not found")));

		return reservationResponse;
	}

}
