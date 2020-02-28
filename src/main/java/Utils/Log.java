package Utils;
 
import org.apache.log4j.Logger;
/**
 * method to Initialize Log4j logs
 */
 public class Log {
 
	 
	 /**
		 * method to Initialize Log4j logs
		 */
 private static Logger Log = Logger.getLogger(Log.class.getName());//
 
 /**
	 * Log a message with the INFO level
	 * @param message info message
	 */
 
 public static void info(String message) {
 Log.info(message);
 
 }
 /**
	 * Log a message with the warn level
	 * @param message warn message
	 */
 
 public static void warn(String message) {

    Log.warn(message);
 
 }
 /**
	 * Log a message with the error level
	 * @param message error message
	 */
 
 
 public static void error(String message) {
 
    Log.error(message);
 
 }
 /**
	 * Log a message with the fatal level
	 * @param message fatal message
	 */
 
 
 public static void fatal(String message) {
 
    Log.fatal(message);
 
 }
 /**
	 * Log a message with the debug level
	 * @param message debug message
	 */
 
 
 public static void debug(String message) {
 
    Log.debug(message);
 
 }
 
}