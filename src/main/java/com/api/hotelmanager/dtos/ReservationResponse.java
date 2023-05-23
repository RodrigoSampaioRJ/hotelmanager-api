package com.api.hotelmanager.dtos;

import java.time.Instant;

import com.api.hotelmanager.entities.Guest;
import com.api.hotelmanager.entities.Room;

import lombok.Builder;

@Builder
public record ReservationResponse(Guest guest, Room room, Instant checkIn, Instant checkOut) {

}
