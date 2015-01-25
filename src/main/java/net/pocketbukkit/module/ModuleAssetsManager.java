package net.pocketbukkit.module;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public final class ModuleAssetsManager{
	private JarFile jar;
	public ModuleAssetsManager(JarFile jar){
		this.jar = jar;
	}
	public InputStream open(String file) throws IOException{
		return jar.getInputStream(jar.getJarEntry(file));
	}
	public String[] list(String path) throws IOException{
		path = path.replace('\\', '/');
		if(!path.endsWith("/")){
			path += "/";
		}
		Enumeration<JarEntry> entries = jar.entries();
		List<String> list = new ArrayList<String>();
		while(entries.hasMoreElements()){
			JarEntry entry = entries.nextElement();
			if(!entry.isDirectory()){
				if(entry.getName().startsWith(path)){
					list.add(entry.getName().substring(path.length()));
				}
			}
		}
		String[] result = new String[list.size()];
		list.toArray(result);
		return result;
	}
}
