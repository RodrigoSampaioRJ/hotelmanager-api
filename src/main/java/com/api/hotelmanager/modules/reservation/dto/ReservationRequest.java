package com.api.hotelmanager.modules.reservation.dto;

import com.api.hotelmanager.modules.guest.entity.Guest;
import com.api.hotelmanager.modules.room.entity.Room;
import lombok.Builder;

import java.time.Instant;

@Builder
public record ReservationRequest(Guest guest, Room room,
		Instant checkIn,
		Instant checkOut) {

}
