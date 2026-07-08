class Logger {

    private static Logger instance;

    private int logCount = 0;

    private Logger() {
        System.out.println("Logger instance created.");
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        logCount++;
        System.out.println("[LOG #" + logCount + "] " + message);
    }
}

public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Application started");

        Logger logger2 = Logger.getInstance();
        logger2.log("User logged in");

        if (logger1 == logger2) {
            System.out.println("logger1 and logger2 refer to the SAME instance.");
        } else {
            System.out.println("Different instances were created.");
        }
    }
}