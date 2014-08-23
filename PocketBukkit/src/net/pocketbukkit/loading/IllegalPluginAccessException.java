package net.pocketbukkit.loading;

@SuppressWarnings("serial")
public class IllegalPluginAccessException extends RuntimeException {
    public IllegalPluginAccessException() {
    	
    }

    public IllegalPluginAccessException(String msg) {
        super(msg);
    }
}