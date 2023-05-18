package com.api.hotelmanager.dtos;

import lombok.Builder;

@Builder
public record GuestResponse (String name, String email, String phone){}
