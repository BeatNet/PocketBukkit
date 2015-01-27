package net.pocketbukkit.addon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.blockserver.Server;
/*
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;
*/
public class AddonManager{
	private Server server;
	private File addonsDir;
	private Map<String, Addon> addons = new HashMap<String, Addon>();

	public AddonManager(Server server, File addonsDir){
		this.server = server;
		this.addonsDir = addonsDir;
		loadAddons();
	}
	private void loadAddons(){
		for(File addonFile: addonsDir.listFiles(new FilenameFilter(){
			@Override
			public boolean accept(File file, String name){
				return file.equals(addonsDir) && name.toLowerCase(Locale.US).endsWith(".js");
			}
		})){
			try{
				loadAddon(addonFile);
			}
			catch(Exception ex){
				try{
					server.getLogger().error("Error parsing addon at %s: %s", addonFile.getCanonicalPath(), ex.getCause() == null ? ex.getMessage():ex.getCause().getMessage());
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	public void loadAddon(File file) throws Exception{
		loadAddon(getFileContents(file), file.getCanonicalPath());
	}
	public void loadAddon(String src, String sourceName) throws Exception{
		Addon addon = new Addon(this, src);
		//Context ctx = null;
//		if(addon.getBind() != null){
//			Addon bind = addons.get(addon.getBind());
//			if(bind == null){
//				throw new BindNotFoundException(addon);
//			}
//			
//		}
//		else{
//			
//		}
		//addon.init(ctx, sourceName);
		addons.put(addon.getName(), addon);
	}
	public static String getFileContents(File file) throws IOException{
		InputStream is = new FileInputStream(file);
		StringBuilder builder = new StringBuilder(is.available());
		int i;
		while((i = is.read()) != -1){
			builder.append((char) i);
		}
		is.close();
		return builder.toString();
	}
	public Server getServer(){
		return server;
	}
	public File getAddonsDir(){
		return addonsDir;
	}
	@Override
	protected void finalize() throws Throwable{
		super.finalize();
		//Context.exit();
	}
}
