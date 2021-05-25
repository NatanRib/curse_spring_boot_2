package com.nataribeiro.cursospringboot2.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Long id) {
		super("Reource not found. Id " + id);
	}
}
