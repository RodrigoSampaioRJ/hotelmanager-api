package com.api.hotelmanager.modules.guest.dto;

import lombok.Builder;

@Builder
public record GuestResponse (String name, String email, String phone){}
