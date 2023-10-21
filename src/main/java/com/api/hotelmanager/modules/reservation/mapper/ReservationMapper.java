package com.api.hotelmanager.modules.reservation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.api.hotelmanager.modules.reservation.dto.ReservationRequest;
import com.api.hotelmanager.modules.reservation.dto.ReservationResponse;
import com.api.hotelmanager.modules.reservation.entity.Reservation;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    
    @Mapping(target = "id", ignore = true)
    Reservation reservationRequestToReservation(ReservationRequest reservationRequest);
    ReservationResponse reservationToReservationResponse(Reservation reservation);
    
}
