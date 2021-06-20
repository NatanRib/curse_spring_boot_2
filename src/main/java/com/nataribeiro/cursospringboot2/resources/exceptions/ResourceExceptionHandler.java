package com.nataribeiro.cursospringboot2.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nataribeiro.cursospringboot2.services.exceptions.DataBaseException;
import com.nataribeiro.cursospringboot2.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException exception, HttpServletRequest request){
		String error = "Resource not found";
		String message = exception.getMessage();
		HttpStatus status = HttpStatus.NOT_FOUND;
		String path = request.getRequestURI();
		return ResponseEntity.status(status).body(new StandardError(Instant.now(), status.value(), error, message, path));
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> database(DataBaseException exception, HttpServletRequest request){
		String error = "Resource not found";
		String message = exception.getMessage();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String path = request.getRequestURI();
		return ResponseEntity.status(status).body(new StandardError(Instant.now(), status.value(), error, message, path));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> argumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest req){
		String error = "property not valid";
		String message = ex.getMessage();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String path = req.getRequestURI();
		return ResponseEntity.status(status).body(new StandardError(Instant.now(), status.value(), error, message, path));
		
	}
}

