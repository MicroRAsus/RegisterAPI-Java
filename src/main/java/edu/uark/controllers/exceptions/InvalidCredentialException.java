package edu.uark.controllers.exceptions;

public class InvalidCredentialException extends RuntimeException {
	public InvalidCredentialException(String parameterName) {
		super("Invalid Credential: ".concat(parameterName));
	}

	private static final long serialVersionUID = 1597574692430394082L;
}