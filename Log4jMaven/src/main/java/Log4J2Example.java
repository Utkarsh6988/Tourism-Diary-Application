import org.apache.logging.log4j.LogManager; // class
import org.apache.logging.log4j.Logger; // interface

public class Log4J2Example
{
    private static final Logger l = LogManager.getLogger(Log4J2Example.class);

    public static void main(String[] args) 
    {
        l.info("This is an info message");
        l.warn("This is a warning message");
        l.error("This is an error message");
        l.fatal("This is a fatal message");
    }
}

//Logger	::Used to log messages at various levels
//log4j2.xml	::Configuration file
//PatternLayout	::Controls format of log messages
//Appenders	::Output target (console, file, etc.)
//Levels	::Control what kinds of messages appear (DEBUG, INFO, ERROR, etc.)

//Fatal Level is the highest priority level in Log4J2
//Trace Level is the lowest priority level in Log4J2
