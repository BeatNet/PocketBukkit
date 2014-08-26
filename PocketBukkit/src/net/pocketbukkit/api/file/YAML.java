package net.pocketbukkit.api.file;

import java.io.*;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;


public class YAML {
	@SuppressWarnings("unchecked")
	public static void readYAML(String File) {
		Yaml yaml = new Yaml();
		try {
			InputStream ios = new FileInputStream(new File(File));
         
			Map<String,Object> result = (Map<String,Object>)yaml.load(ios);
			returnStatement(result.toString());   
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String returnStatement(String data) {
		return data;
	}
}