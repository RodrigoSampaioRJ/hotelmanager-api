package com.api.hotelmanager.exceptions.dto;

import lombok.Builder;


@Builder
public record ArgumentNotValidExceptionDto(String message, String field) {

}
