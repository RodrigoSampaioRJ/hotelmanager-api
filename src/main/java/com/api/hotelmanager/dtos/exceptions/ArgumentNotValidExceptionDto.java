package com.api.hotelmanager.dtos.exceptions;

import lombok.Builder;


@Builder
public record ArgumentNotValidExceptionDto(String message, String field) {

}
