package com.api.hotelmanager.dtos;

import lombok.Builder;

@Builder
public record HotelRequest (String name, String address, Integer stars) {}
