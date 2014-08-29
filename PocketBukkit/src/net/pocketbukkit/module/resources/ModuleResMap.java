package net.pocketbukkit.module.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ModuleResMap<T>{
	private Map<String, ModuleResource<T>> map = new HashMap<String, ModuleResource<T>>();
	public void add(String name, String file, T value){
		String[] tokens = file.split("/");
		file = tokens[tokens.length - 1];
		tokens = file.split("-");
		List<String> args = new ArrayList<String>();
		for(int i = 1; i < tokens.length; i++){ // should run nothing if length <= 1
			args.add(tokens[i]);
		}
		String[] modifiers = new String[args.size()];
		args.toArray(modifiers);
		if(!map.containsKey(name)){
			map.put(name, new ModuleResource<T>());
		}
		ModuleResource<T> res = map.get(name);
		res.add(modifiers, value);
	}
	public T get(String name, Map<String, Double> ratios){
		ModuleResource<T> res = map.get(name);
		if(res instanceof ModuleResource){
			return res.choose(ratios);
		}
		return null;
	}
}
