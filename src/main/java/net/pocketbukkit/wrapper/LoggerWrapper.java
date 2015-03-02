package net.pocketbukkit.wrapper;

import java.util.logging.Logger;

public class LoggerWrapper extends Logger{
    private org.blockserver.ui.Logger logger;

    public LoggerWrapper(org.blockserver.ui.Logger logger){
        super("Logger", "");
        this.logger = logger;
    }

    protected LoggerWrapper(String name, String resourceBundleName) {
        super(name, resourceBundleName);
    }

    public void info(String message){
        logger.info(message);
    }

    public void warning(String message){
        logger.warning(message);
    }

    public void severe(String message){
        logger.fatal(message);
    }
}
