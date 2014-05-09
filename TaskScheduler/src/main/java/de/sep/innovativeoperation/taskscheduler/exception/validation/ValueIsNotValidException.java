package de.sep.innovativeoperation.taskscheduler.exception.validation;

public class ValueIsNotValidException extends ValidationFailureException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1069371965341602179L;

	/**
	 * 
	 */
	public ValueIsNotValidException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ValueIsNotValidException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ValueIsNotValidException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ValueIsNotValidException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ValueIsNotValidException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
