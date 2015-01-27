package net.pocketbukkit.addon;

import java.util.ArrayList;
import java.util.List;

/*
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
*/

public class Addon{
	private AddonManager manager;
	private String src;
	private String name = null;
	private AddonApiVersion apiVersion = null;
	private String version = null;
	private String[] authors = new String[0];
	private List<String> depends = new ArrayList<String>();
	private String bind = null;
	//private Context ctx = null;

	public Addon(AddonManager mgr, String src) throws Exception{
		manager = mgr;
		this.src = src;
		String[] lines = src.split("\n");
		int i = 0;
		int j = -1;
		for(String line: lines){
			if(line.trim().equalsIgnoreCase("{{PocketBukkit Addon}}")){
				j = i;
			}
			if(j != -1){
				parsePropertyLine(line);
			}
			else if(line.trim().equals("...")){
				break;
			}
			i++;
		}
		if(j == -1){
			throw new Exception("Not a PocketBukkit addon: signature not found");
		}
		if(name == null) throw new Exception("Property 'name' missing");
		if(apiVersion == null) throw new Exception("Property 'api' missing");
		if(version == null) throw new Exception("Property 'version' missing");
	}
	private void parsePropertyLine(String line){
		String[] tokens = line.split("=", 2);
		String key = tokens[0];
		String value = tokens[1];
		if(key.equalsIgnoreCase("name")){
			name = value;
		}
		else if(key.equalsIgnoreCase("api")){
			apiVersion = new AddonApiVersion(value);
		}
		else if(key.equalsIgnoreCase("author")){
			authors = new String[]{value};
		}
		else if(key.equalsIgnoreCase("authors")){
			authors = value.split(", ");
			for(int i = 0; i < authors.length; i++){
				authors[i] = authors[i].trim();
			}
		}
		else if(key.equalsIgnoreCase("version")){
			version = value;
		}
		else if(key.equalsIgnoreCase("depends")){
			for(String name: value.split(",")){
				depends.add(name);
			}
		}
//		else if(key.equalsIgnoreCase("bind")){
//			bind = value;
//		}
		else{
			manager.getServer().getLogger().warning("Unknown addon property: %s (source `%s`)", key, line);
		}
	}
	/*
	public void init(Context ctx, String sourceName){
//		if(ctx == null && bind != null){
//			throw new IllegalArgumentException("Context must not be null because addon needs to bind");
//		}
		Script script = ctx.compileString(src, sourceName, 0, null);
		Scriptable scope = ctx.initStandardObjects(new AddonAPIs.TopNamespace(), false);
		ScriptableObject scriptable = (ScriptableObject) scope;
		// TODO
	}
	*/

	public String getName(){
		return name;
	}
	public AddonApiVersion getApiVersion(){
		return apiVersion;
	}
	public String getVersion(){
		return version;
	}
	public String getBind(){
		return bind;
	}
	public String[] getDepends(){
		return (String[]) depends.toArray();
	}
	/*
	public Context getContext(){
		return ctx;
	}
	*/
	public AddonManager getManager(){
		return manager;
	}
}
