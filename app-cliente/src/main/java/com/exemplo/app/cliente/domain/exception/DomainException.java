package com.exemplo.app.cliente.domain.exception;

public class DomainException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DomainException(String message) {
		super(message);
	}
}
