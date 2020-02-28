package Base;

import Utils.Log;

/**
 * to signal and handle exception events occurred
 */
public class AppException extends Exception {

	private static final long serialVersionUID = 1L;
	private static String exceptionMessage = "AppException";
	
	/**
	 * method to get and return exception message
	 */
	private String getExceptionMessage() {
		return exceptionMessage;
	}

	/**
	 * method to get and return exception message
	 * @param exceptionMessage
	 */
	private void setExceptionMessage(String exceptionMessage) {
		AppException.exceptionMessage = AppException.exceptionMessage + "\n" + exceptionMessage;
	}

	/**
	 * Returns the detail message string 
	 */
	
	public AppException() {
		super();
		exceptionMessage = exceptionMessage + "\n" + getMessage();
	}
	
	/**
	 * get a new exception and returns the message
	 * 	@param  exception exception occurred
	 * @param exMessage exception message
	 */
	public AppException(Exception exception, String exMessage){
		super(exception);
		setExceptionMessage(exMessage);
	}
	
	/**
	 * method which handles and  print the stack trace info of the exception
	 */
	
	public void handleException() {
		Log.info(getExceptionMessage() + " : " + getMessage() + "\n");
		printStackTrace();
		AppException.exceptionMessage = null;
	}
	
}
