package com.webservices.restfulwebservices.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse response= new ExceptionResponse(new Date(), "Validation failed", ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllException
	(Exception ex, WebRequest request) throws Exception{
		ExceptionResponse response= new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
	
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleUserNotFoundException
	(UserNotFoundException ex, WebRequest request) throws Exception{
		ExceptionResponse response= new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
	
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = UserCreationException.class)
	public final ResponseEntity<ExceptionResponse> handleUserCreationException
	(UserCreationException ex, WebRequest request) throws Exception{
		ExceptionResponse response= new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
	
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}
	
}
