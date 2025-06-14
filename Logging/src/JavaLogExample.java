import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class JavaLogExample {

	public static void main(String[] args) throws SecurityException, IOException {
              
		 Logger logger = Logger.getLogger("MyLogger"); // Creates Logger Instance
	        FileHandler fh = new FileHandler("D:\\welcomeworld.log",true);// Sends log output to a file
	        logger.addHandler(fh); // This connects the FileHandler (fh) to the Logger
	        //logger.setUseParentHandlers(false); // disables console output
	        fh.setFormatter(new SimpleFormatter());// Sets the format for how log messages appear in the file

	        logger.info("This is an info message, welcome");
	        logger.warning("This is a warning message, be careful");
	}
}

//More times you run the code new logs will be added in the file in D drive.