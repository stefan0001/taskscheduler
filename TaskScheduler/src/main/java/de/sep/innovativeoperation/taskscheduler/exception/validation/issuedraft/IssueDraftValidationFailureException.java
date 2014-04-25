package de.sep.innovativeoperation.taskscheduler.exception.validation.issuedraft;

import de.sep.innovativeoperation.taskscheduler.exception.validation.ValidationFailureException;

public class IssueDraftValidationFailureException extends ValidationFailureException{

	/**
	 * 
	 */
	public IssueDraftValidationFailureException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public IssueDraftValidationFailureException(String message,
			Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public IssueDraftValidationFailureException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public IssueDraftValidationFailureException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public IssueDraftValidationFailureException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 8564269249652376752L;

}
