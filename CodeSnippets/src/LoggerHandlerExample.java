import java.util.logging.*;

public class LoggerHandlerExample {
	private static final Logger logger = Logger.getLogger("MyLogger");

	public static void main(String[] args) {
		ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(Level.ALL);
		logger.addHandler(handler);
//		logger.setLevel(Level.ALL);
		logger.info("Info message");
		logger.severe("Severe message");
	}
} 