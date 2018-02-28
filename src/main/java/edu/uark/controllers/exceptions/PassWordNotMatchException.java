package edu.uark.controllers.exceptions;

public class PassWordNotMatchException extends RuntimeException {
	public PassWordNotMatchException(String parameterName) {
		super(parameterName.concat(" is not correct."));
	}

	private static final long serialVersionUID = 673195628141355966L;
}