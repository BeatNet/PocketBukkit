/***
name: ExamplePlugin
version: 1.0-SNAPSHOT
mainClass: ExamplePlugin
*/
var plugin = null;

function init(wrapper){
    plugin = wrapper;
}

function onEnable(){
    plugin.getLogger().info("I've been enabled!");
}

function onDisable(){
    plugin.getLogger().info("I've been enabled!");
}