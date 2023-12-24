package com.api.hotelmanager.exceptions.dto;

import lombok.Builder;

@Builder
public record EntityNotFoundExceptionDto(String message) {
    
}
