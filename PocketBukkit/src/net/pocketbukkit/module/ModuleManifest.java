package net.pocketbukkit.module;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.jar.JarFile;

import org.yaml.snakeyaml.Yaml;

public class ModuleManifest{
	private JarFile jar;
	private String name, version;
	private int minAPI;
	private String packageName, mainClass;
	private ModuleClassLoader loader;
	private Module mainClassObject;
	@SuppressWarnings("unchecked")
	public ModuleManifest(File file, InputStream stream, JarFile jar, ModuleManager manager) throws Exception{
		this.jar = jar;
		Yaml yaml = new Yaml();
		Map<String, Object> map = (Map<String, Object>) yaml.load(stream);
		String[] requires = {
				"name", "version", "min-api", "package", "main"
		};
		for(String require: requires){
			if(!map.containsKey(require)){
				throw new Exception("Required property " + require + " is missing");
			}
		}
		name = (String) map.get("name");
		version = (String) map.get("version");
		minAPI = (int) map.get("min-api");
		packageName = (String) map.get("package");
		mainClass = (String) map.get("main");
		if(!mainClass.startsWith(packageName)){
			throw new Exception("Main class must be in the package of the plugin");
		}
		loader = new ModuleClassLoader(file, manager);
		mainClassObject = loader.validate(mainClass);
	}
	public Module getMainClassObject(){
		return mainClassObject;
	}
	public ModuleClassLoader getClassLoader(){
		return loader;
	}
	public String getName(){
		return name;
	}
	public String getVersion(){
		return version;
	}
	public int getMinAPI(){
		return minAPI;
	}
	public JarFile getJar(){
		return jar;
	}
	@Override
	protected void finalize(){
		try{
			jar.close();
		}
		catch(IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
