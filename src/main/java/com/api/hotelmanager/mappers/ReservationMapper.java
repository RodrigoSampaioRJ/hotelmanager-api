package com.api.hotelmanager.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.api.hotelmanager.dtos.ReservationRequest;
import com.api.hotelmanager.dtos.ReservationResponse;
import com.api.hotelmanager.entities.Reservation;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

	ReservationResponse reservationToReservationResponse(Reservation reservation);
	@Mapping(target = "id", ignore = true)
	Reservation reservationRequestToReservation(ReservationRequest reservationRequest);
}
