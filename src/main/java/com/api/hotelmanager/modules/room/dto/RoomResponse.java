package com.api.hotelmanager.modules.room.dto;

import com.api.hotelmanager.modules.hotel.entity.Hotel;
import com.api.hotelmanager.modules.reservation.entity.Reservation;
import lombok.Builder;

import java.util.List;

@Builder
public record RoomResponse(
        Integer number,
        String type,
        Double price,
        List<Reservation> reservations,
        Hotel hotel) {
}
