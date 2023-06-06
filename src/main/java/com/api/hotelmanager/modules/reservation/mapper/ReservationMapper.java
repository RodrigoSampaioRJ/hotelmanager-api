package com.api.hotelmanager.modules.reservation.mapper;

import com.api.hotelmanager.modules.reservation.dto.ReservationRequest;
import com.api.hotelmanager.modules.reservation.dto.ReservationResponse;
import com.api.hotelmanager.modules.reservation.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

	ReservationResponse reservationToReservationResponse(Reservation reservation);
	@Mapping(target = "id", ignore = true)
	Reservation reservationRequestToReservation(ReservationRequest reservationRequest);
}
