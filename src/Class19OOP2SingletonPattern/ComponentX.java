package Class19OOP2SingletonPattern;

public class ComponentX {
    private Logger myLogger = Logger.getInstance();

    public void Log(String message) {
        myLogger.logMessage(message);
    }
}
