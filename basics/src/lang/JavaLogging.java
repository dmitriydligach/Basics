package lang;

import java.util.logging.*;

public class JavaLogging {

	public static void main(String[] args) {

		Logger logger = Logger.getLogger("my.stuff");
		
		logger.setLevel(Level.SEVERE);
		
		logger.log(Level.INFO, "this is a fine log message");
		logger.log(Level.FINEST, "this is the finest log message");
		logger.log(Level.SEVERE, "this is a severe log message!");
		logger.log(Level.FINE, "this is a FINE message");
	}

}
