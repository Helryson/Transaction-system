package com.transacao.teste.resources.exception;

public class InvalidResourceException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public InvalidResourceException(String msg) {
		super(msg);
	}

}
