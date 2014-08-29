package net.pocketbukkit.module.resources;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ModuleResources{
	private JarFile jar;
	private ModuleResMap<String> strings = new ModuleResMap<String>();
	private ModuleResMap<Integer> ints = new ModuleResMap<Integer>();
	private ModuleResMap<List<Integer>> intArrays = new ModuleResMap<List<Integer>>();
	private ModuleResMap<Double> doubles = new ModuleResMap<Double>();
	private ModuleResMap<List<Double>> doubleArrays = new ModuleResMap<List<Double>>();
	private ModuleResMap<Boolean> bools = new ModuleResMap<Boolean>();
	public ModuleResources(JarFile jar){
		this.jar = jar;
		load();
	}
	private void load(){
		Enumeration<JarEntry> entries = jar.entries();
		while(entries.hasMoreElements()){
			JarEntry entry = entries.nextElement();
			if(entry.isDirectory()){
				continue;
			}
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			try{
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse(jar.getInputStream(entry));
				Element root = doc.getDocumentElement();
				NodeList list = root.getChildNodes();
				for(int i = 0; i < list.getLength(); i++){
					Element item = (Element) list.item(i);
					String name = item.getAttribute("name");
					String type = item.getTagName();
					String file = entry.getName();
					if(type.equalsIgnoreCase("string")){
						strings.add(name, file, item.getNodeValue());
					}
					else if(type.equalsIgnoreCase("integer") || type.equalsIgnoreCase("int")){
						ints.add(name, file, Integer.parseInt(item.getNodeValue()));
					}
					else if(type.equalsIgnoreCase("int-array") || type.equalsIgnoreCase("integer-array")){
						NodeList items = item.getChildNodes();
						List<Integer> intList = new ArrayList<Integer>();
						for(int j = 0; j < items.getLength(); j++){
							intList.add(Integer.parseInt(items.item(j).getNodeValue()));
						}
						intArrays.add(name, file, intList);
					}
					else if(type.equalsIgnoreCase("double")){
						doubles.add(name, file, Double.parseDouble(item.getNodeValue()));
					}
					else if(type.equalsIgnoreCase("double-array")){
						NodeList items = item.getChildNodes();
						List<Double> doubleList = new ArrayList<Double>();
						for(int j = 0; j < items.getLength(); j++){
							doubleList.add(Double.parseDouble(items.item(j).getNodeValue()));
						}
						doubleArrays.add(name, file, doubleList);
					}
					else if(type.equalsIgnoreCase("bool") || type.equalsIgnoreCase("boolean")){
						bools.add(name, file, Boolean.parseBoolean(item.getNodeValue()));
					}
				}
			}
			catch(Exception e){
				e.printStackTrace();
				continue;
			}
		}
	}
	public String getString(String name, Map<String, Double> modifiers){
		return strings.get(name, modifiers);
	}
	public int getInteger(String name, Map<String, Double> modifiers){
		return ints.get(name, modifiers);
	}
	public int[] getIntegerArray(String name, Map<String, Double> modifiers){
		List<Integer> intList = intArrays.get(name, modifiers);
		int[] array = new int[intList.size()];
		int i = 0;
		for(int integer: intList){
			array[i++] = integer;
		}
		return array;
	}
	public double getDouble(String name, Map<String, Double> modifiers){
		return doubles.get(name, modifiers);
	}
	public double[] getDoubleArray(String name, Map<String, Double> modifiers){
		List<Double> list = doubleArrays.get(name, modifiers);
		double [] array = new double[list.size()];
		int i = 0;
		for(double integer: list){
			array[i++] = integer;
		}
		return array;
	}
	public boolean getBoolean(String name, Map<String, Double> modifiers){
		return bools.get(name, modifiers);
	}
}
