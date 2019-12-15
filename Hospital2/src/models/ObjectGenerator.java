package models;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Iterator;


public class ObjectGenerator {
	
	public static ArrayList<Object> generate(String filePath, String[] args ) {
		
		JSONParser parser = new JSONParser();
		
		try {
			Reader reader = new FileReader(filePath);
            JSONObject json = (JSONObject) parser.parse(reader);
            for ( Iterator<?> iterator = json.keySet().iterator(); iterator.hasNext(); ) {
            	String key = (String) iterator.next();
            	JSONArray items = (JSONArray) json.get(key);
            	System.out.println(key);
            	for ( Object item : items ) {
            		JSONObject t = (JSONObject) item;
            		
            	}
            	
            }
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
}
