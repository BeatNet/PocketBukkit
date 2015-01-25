package net.pocketbukkit.module;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

public class ModuleClassLoader extends URLClassLoader{
	private Map<String, Class<?>> cache = new HashMap<String, Class<?>>(1);
	private ModuleManager manager;
	public ModuleClassLoader(File file, ModuleManager manager) throws MalformedURLException{
		super(new URL[]{file.toURI().toURL()});
		this.manager = manager;
	}
	public Module validate(String main) throws Exception{
		try{
			Class<?> mainClass0 = Class.forName(main, true, this);
			Class<? extends Module> mainClass = mainClass0.<Module> asSubclass(Module.class);
			Module instance = mainClass.newInstance();
			return instance;
		}
		catch(ClassNotFoundException e){
			throw new Exception("Main class missing");
		}
		catch(ClassCastException e){
			throw new Exception("Main class must extend net.pocketbukkit.module.Module");
		}
		catch(IllegalAccessException e){
			throw new Exception("Constructor of main class is not visible");
		}
		catch(InstantiationException e){
			throw new Exception("Main class does not have a nullary constructor or is of abnormal type", e);
		}
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException{
		return findClass(name, true);
	}
	public Class<?> findClass(String name, boolean searchOutside) throws ClassNotFoundException{
		if(cache.containsKey(name)){
			return cache.get(name);
		}
		if(searchOutside){
			Class<?> result = manager.findClass(name, this);
			if(result instanceof Class<?>){
				return result;
			}
		}
		return super.findClass(name);
	}
}
