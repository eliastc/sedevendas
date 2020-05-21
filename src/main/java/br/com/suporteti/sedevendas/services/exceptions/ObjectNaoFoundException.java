package br.com.suporteti.sedevendas.services.exceptions;

public class ObjectNaoFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectNaoFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNaoFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
