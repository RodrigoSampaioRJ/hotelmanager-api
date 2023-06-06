package com.api.hotelmanager.modules.reservation.dto;

import java.time.Instant;

import com.api.hotelmanager.modules.guest.entity.Guest;
import com.api.hotelmanager.modules.room.entity.Room;

import lombok.Builder;

@Builder
public record ReservationResponse(Guest guest, Room room, Instant checkIn, Instant checkOut) {

}
