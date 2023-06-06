package com.api.hotelmanager.modules.reservation.service;

import org.springframework.stereotype.Service;

import com.api.hotelmanager.modules.reservation.dto.ReservationRequest;
import com.api.hotelmanager.modules.reservation.dto.ReservationResponse;
import com.api.hotelmanager.modules.reservation.entity.Reservation;
import com.api.hotelmanager.modules.reservation.mapper.ReservationMapper;
import com.api.hotelmanager.modules.reservation.repository.ReservationRepository;

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
