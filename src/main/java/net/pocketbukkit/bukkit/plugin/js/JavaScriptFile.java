package net.pocketbukkit.bukkit.plugin.js;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.Callable;

/**
 * Wrapper for JavaScript files.
 */
public class JavaScriptFile {
    private ScriptEngine engine;
    private Invocable invocable;
    private File script;

    public JavaScriptFile(File script, ScriptEngine engine) throws FileNotFoundException, ScriptException {
        if(!script.exists()){
            throw new IllegalArgumentException("Script file does not exist.");
        }
        engine.eval(new FileReader(script)); //We will assume that the file contains JavaScript
        this.engine = engine;
        this.invocable = (Invocable) engine;
        this.script = script;
    }

    public Object callFunction(String functionName) throws ScriptException, NoSuchMethodException {
        return invocable.invokeFunction(functionName);
    }

    public Object callFunction(String functionName, Object... args) throws ScriptException, NoSuchMethodException {
        return invocable.invokeFunction(functionName, args);
    }

    public Object callMethod(Object parent, String method) throws ScriptException, NoSuchMethodException {
        return invocable.invokeMethod(parent, method);
    }

    public Object callMethod(Object parent, String method, Object... args) throws ScriptException, NoSuchMethodException {
        return invocable.invokeMethod(parent, method, args);
    }

    public void feed(String code) throws ScriptException {
        engine.eval(code);
    }

    public Object getInterface(String var, Class clazz){
        return invocable.getInterface(var, clazz);
    }

    public File getFile(){
        return script;
    }

    public ScriptEngine getEngine(){
        return engine;
    }
}
