package com.api.hotelmanager.modules.reservation.mapper;

import com.api.hotelmanager.modules.reservation.dto.ReservationRequest;
import com.api.hotelmanager.modules.reservation.dto.ReservationResponse;
import com.api.hotelmanager.modules.reservation.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ReservationMapper {

	ReservationResponse mapToReservationResponse(Reservation reservation);
	@Mapping(target = "id", ignore = true)
	Reservation mapToReservation(ReservationRequest reservationRequest);
}
