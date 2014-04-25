package de.sep.innovativeoperation.taskscheduler.exception.validation;

public class ValidationFailureException extends Exception {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1084329371641196868L;

	/**
	 * 
	 */
	public ValidationFailureException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ValidationFailureException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ValidationFailureException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ValidationFailureException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ValidationFailureException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


}
