package com.api.hotelmanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.hotelmanager.exceptions.dto.EmailAlreadyInUseExceptionDto;
import com.api.hotelmanager.exceptions.dto.EntityNotFoundExceptionDto;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(EmailAlreadyInUseException.class)
	public ResponseEntity<EmailAlreadyInUseExceptionDto> emailAlreadyInUseExceptionHandler(EmailAlreadyInUseException ex, HttpServletRequest req){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new EmailAlreadyInUseExceptionDto(ex.getMessage()));
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<EntityNotFoundExceptionDto> entityNotFoundExceptionHandler(EntityNotFoundException ex, HttpServletRequest req) {
		return ResponseEntity.status(404).body(new EntityNotFoundExceptionDto(ex.getMessage())) ;
	}
}
