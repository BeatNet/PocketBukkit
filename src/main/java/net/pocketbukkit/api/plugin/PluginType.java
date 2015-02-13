package net.pocketbukkit.api.plugin;

/**
 * Represents a Plugin Type.
 */
public enum PluginType {
    JAVA_JAR(".jar"), JAVA_CLASS(".class"), JAVASCRIPT(".js");

    private String type;

    private PluginType(String type){
        this.type = type;
    }

    public static PluginType getTypeByExtension(String name){
        if(name.endsWith(".jar")){
            return PluginType.JAVA_JAR;
        } else if(name.endsWith(".class")){
            return PluginType.JAVA_CLASS;
        } else if(name.endsWith(".js")){
            return PluginType.JAVASCRIPT;
        } else {
            return null;
        }
    }
}
