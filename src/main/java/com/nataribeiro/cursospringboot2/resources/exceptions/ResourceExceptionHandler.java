package com.nataribeiro.cursospringboot2.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nataribeiro.cursospringboot2.services.exceptions.DataBaseException;
import com.nataribeiro.cursospringboot2.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException exception, HttpServletRequest request){
		String error = "Resource not found";
		String messagem = exception.getMessage();
		HttpStatus status = HttpStatus.NOT_FOUND;
		String path = request.getRequestURI();
		return ResponseEntity.status(status).body(new StandardError(Instant.now(), status.value(), error, messagem, path));
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> database(DataBaseException exception, HttpServletRequest request){
		String error = "Resource not found";
		String messagem = exception.getMessage();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String path = request.getRequestURI();
		return ResponseEntity.status(status).body(new StandardError(Instant.now(), status.value(), error, messagem, path));
	}
}

