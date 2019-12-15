package models;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ContainerObject {

	private String name;
	private int totalWeight;
	private ArrayList<Object> list;
	
	public void generate(String path) {
		JSONParser parser = new JSONParser();
		
		try {
			Reader reader = new FileReader(path);
            JSONObject json = (JSONObject) parser.parse(reader);
            for ( Iterator<?> iterator = json.keySet().iterator(); iterator.hasNext(); ) {
            	String key = (String) iterator.next();
            	JSONArray items = (JSONArray) json.get(key);
            	for ( Object item : items ) {
            		Disease2.setParameters((JSONObject)item);            		
            	}
            	
            }
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return name;
	}	

	public int getTotalWeight() {
		return totalWeight;
	}
	
	public ArrayList<Object> getList() {
		return list;
	}


	public ContainerObject(String path) {
		this.generate(path);
	}
}
