package models;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.mifmif.common.regex.util.Iterator;


public class ObjectGenerator {
	
	public static ArrayList<Object> generate(String filePath, String[] args ) {
		
		JSONParser parser = new JSONParser();
		
		try {
			Reader reader = new FileReader(filePath);
            JSONObject json = (JSONObject) parser.parse(reader);
            
            for ( java.util.Iterator i = json.keySet().iterator(); i.hasNext(); ) {
            	String key = (String) i.next();
            	System.out.println(key);
            	JSONArray a = (JSONArray) json.get(key);
            	System.out.println(a);
            	
            }
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
}
