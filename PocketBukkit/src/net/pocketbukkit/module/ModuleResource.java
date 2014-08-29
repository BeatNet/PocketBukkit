package net.pocketbukkit.module;

import java.util.HashMap;
import java.util.Map;

public class ModuleResource<T>{
	private Map<String[], T> map = new HashMap<String[], T>();
	public void add(String[] args, T value){
		map.put(args, value);
	}
	public T choose(Map<String, Double> args){
		T choosen = null;
		Double currentMax = 0d;
		for(Map.Entry<String[], T> entry: map.entrySet()){
			String[] modifiers = entry.getKey();
			T value = entry.getValue();
			Double quantity = 0d;
			for(String modifier: modifiers){
				if(args.containsKey(modifier)){
					quantity += args.get(modifier);
				}
			}
			if(quantity > currentMax){ // >= or >?
				choosen = value;
			}
		}
		return choosen;
	}
}
