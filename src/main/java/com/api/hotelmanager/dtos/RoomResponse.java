package com.api.hotelmanager.dtos;

import lombok.Builder;

@Builder
public record RoomResponse(Integer number, String type, Double price) {

}
