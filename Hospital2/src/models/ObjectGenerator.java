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
            	System.out.println(items);
            	for ( Object item : items ) {
            		JSONObject t = (JSONObject) item;
            		for ( Iterator<?> iteratorNested = t.keySet().iterator(); iteratorNested.hasNext(); ) {
            			String k = (String) iteratorNested.next();
            			System.out.println( k );
            			System.out.println(t.get(k));
            		}
            	}
            	
            }
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
}
