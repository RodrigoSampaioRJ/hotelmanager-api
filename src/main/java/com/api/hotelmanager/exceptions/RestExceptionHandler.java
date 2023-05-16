package com.api.hotelmanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api.hotelmanager.dtos.exceptions.GuestNotFoundExceptionDto;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(value = {EntityNotFoundException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public GuestNotFoundExceptionDto entityNotFoundExceptionHandler(Exception ex, HttpServletRequest req) {
		
		return new GuestNotFoundExceptionDto(ex.getMessage());

	}

}
