package net.pocketbukkit.bukkit.plugin.js;

import com.avaje.ebean.EbeanServer;
import net.pocketbukkit.wrapper.LoggerWrapper;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;

import javax.script.ScriptException;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by atzeise on 3/9/15.
 */
public class JavaScriptPlugin implements Plugin{
    private JavaScriptFile script;
    private PluginDescriptionFile descriptionFile;
    private net.pocketbukkit.plugin.PluginLoader loader;
    private LoggerWrapper logger;

    public JavaScriptPlugin(JavaScriptFile script, PluginDescriptionFile desc, net.pocketbukkit.plugin.PluginLoader loader, LoggerWrapper logger){
        this.script = script;
        this.descriptionFile = desc;
        this.loader = loader;
        this.logger = logger;
    }

    @Override
    public File getDataFolder() {
        return null;
    }

    @Override
    public PluginDescriptionFile getDescription() {
        return null;
    }

    @Override
    public FileConfiguration getConfig() {
        return null;
    }

    @Override
    public InputStream getResource(String s) {
        return null;
    }

    @Override
    public void saveConfig() {

    }

    @Override
    public void saveDefaultConfig() {

    }

    @Override
    public void saveResource(String s, boolean b) {

    }

    @Override
    public void reloadConfig() {

    }

    @Override
    public PluginLoader getPluginLoader() {
        return null;
    }

    @Override
    public Server getServer() {
        return loader.getServer();
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void onDisable() {
        try {
            script.callFunction("onDisable");
        } catch (ScriptException e) {
            handleScriptException(e);
        } catch (NoSuchMethodException e) {
            getLogger().severe(script.getFile().getName()+" does not have the required method \"onDisable()\"!");
        }
    }

    @Override
    public void onLoad() {
        try {
            script.callFunction("init", this);
        } catch (ScriptException e) {
            handleScriptException(e);
        } catch (NoSuchMethodException e) {
            getLogger().severe(script.getFile().getName()+" does not have the required method \"init(JavaScriptPlugin plugin)\"!");
        }
    }

    private void handleScriptException(ScriptException e) {
        getLogger().warning("ScriptException("+e.getMessage()+") in "+script.getFile().getName()+" at line "+e.getLineNumber()+", column "+e.getColumnNumber());
        e.printStackTrace();
    }

    @Override
    public void onEnable() {
        try {
            script.callFunction("onEnable");
        } catch (ScriptException e) {
            handleScriptException(e);
        } catch (NoSuchMethodException e) {
            getLogger().severe(script.getFile().getName()+" does not have the required method \"onEnable()\"!");
        }
    }

    @Override
    public boolean isNaggable() {
        return false;
    }

    @Override
    public void setNaggable(boolean b) {

    }

    @Override
    public EbeanServer getDatabase() {
        return null;
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String s, String s1) {
        return null;
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public String getName() {
        return descriptionFile.getName();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return null;
    }
}
