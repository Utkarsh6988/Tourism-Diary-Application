import java.util.logging.Logger;

public class LoggingExample {
	private static final Logger logger = Logger.getLogger("MyLogger");

	public static void main(String[] args) {
		logger.info("Info message");
		logger.warning("Warning message");
		logger.severe("Severe message");
	}
}