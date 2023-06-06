package com.api.hotelmanager.modules.room.dto;

import lombok.Builder;

@Builder
public record RoomResponse(Integer number, String type, Double price) {

}
