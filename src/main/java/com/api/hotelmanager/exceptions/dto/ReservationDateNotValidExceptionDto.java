package com.api.hotelmanager.exceptions.dto;

import lombok.Builder;

@Builder
public record ReservationDateNotValidExceptionDto (String message) {}
