package net.pocketbukkit.module;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

//import org.blockserver.Server;

public final class ModuleManager{
	private File dir;
	private Map<String, Module> modules = new HashMap<String, Module>();
	public ModuleManager(File moduleDir){
		if(moduleDir.isFile()){
			throw new IllegalArgumentException("File passed to constructor of ModuleManager must not be a file");
		}
		moduleDir.mkdirs();
		dir = moduleDir;
	}
	public void install(){
		for(File file: dir.listFiles()){
			if(file.isFile()){
				String path = file.getAbsolutePath();
				int length = path.length();
				if(path.substring(length - 4).equalsIgnoreCase(".jar")){
					try{
						loadModule(file);
					}
					catch(IOException e){
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	public Module loadModule(File file) throws IOException{
		JarFile jar = new JarFile(file);
		JarEntry manifestEntry = jar.getJarEntry("Manifest.yml");
		InputStream stream = jar.getInputStream(manifestEntry);
		Module module = null;
		try{
			ModuleManifest manifest = new ModuleManifest(file, stream, jar, this);
			module = manifest.getMainClassObject();
		}
		catch(Exception e){
			stream.close();
			jar.close();
//			Server.getInstance().getLogger().error("Failed loading module at %s. Reason: %s", file.getCanonicalPath(), e.getMessage());
			return null;
		}
		stream.close();
		return module;
	}
	public Class<?> findClass(String name, ClassLoader source){
		for(Module module: modules.values()){
			Class<?> result;
			ModuleClassLoader loader = module.getManifest().getClassLoader();
			if(loader.equals(source)){
				continue;
			}
			try{
				result = loader.findClass(name, false);
			}
			catch(ClassNotFoundException e){
				continue;
			}
			return result;
		}
		return null;
	}
}
