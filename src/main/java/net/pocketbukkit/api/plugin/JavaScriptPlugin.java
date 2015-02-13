package net.pocketbukkit.api.plugin;

import net.pocketbukkit.PocketBukkit;
import net.pocketbukkit.api.PBPlugin;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;

/**
 * An implementation of a Javascript Plugin.
 */
public class JavaScriptPlugin extends PBPlugin{
    private boolean enabled = false;
    private PocketBukkit pb;
    private ScriptEngine engine;
    private File file;

    public JavaScriptPlugin(PocketBukkit pb, ScriptEngine engine, File js) throws FileNotFoundException, ScriptException {
        this.pb = pb;
        this.engine = engine;
        file = js;

        BufferedReader r = new BufferedReader(new FileReader(js));
        String line;
        try {
            line = r.readLine();
            if(!line.startsWith("/**PBPlugin")){
                throw new ScriptException("Not a valid JS plugin: no /**PBPlugin");
            }
            while ((line = r.readLine()) != null){
                if(line.startsWith("name: ")){
                    setName(line.split(" ")[1]);
                } else if(line.startsWith("**/")){
                    break;
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    protected void load(){
        Invocable inv = (Invocable) engine;
        loaded = false;
        try {
            inv.invokeFunction("onLoad", getServer(), getLogger());
            loaded = true;
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onEnable(){
        Invocable inv = (Invocable) engine;
        try {
            inv.invokeFunction("onEnable");
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable(){
        Invocable inv = (Invocable) engine;
        try {
            inv.invokeFunction("onDisable");
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}
