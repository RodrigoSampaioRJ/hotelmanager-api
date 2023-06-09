package com.api.hotelmanager.exceptions;

import com.api.hotelmanager.exceptions.dto.ArgumentNotValidExceptionDto;
import com.api.hotelmanager.exceptions.dto.EntityNotFoundExceptionDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public List<ArgumentNotValidExceptionDto> argumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
		
		List<ArgumentNotValidExceptionDto> argumentNotValidExceptionResponseList = ex.getFieldErrors().stream().map(erro -> ArgumentNotValidExceptionDto.builder()
				.message(erro.getDefaultMessage())
				.field(erro.getField())
				.build())
				.toList();
		
		return argumentNotValidExceptionResponseList;
	}
	
	@ExceptionHandler(value = {EntityNotFoundException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public EntityNotFoundExceptionDto entityNotFoundExceptionHandler(Exception ex, HttpServletRequest req) {
		
		
		return new EntityNotFoundExceptionDto(ex.getMessage());

	}

}
