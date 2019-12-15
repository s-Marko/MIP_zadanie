package models;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Iterator;


public class ObjectGenerator {
	
	public static ArrayList<ContainerObject> generate(String filePath) {
		
		JSONParser parser = new JSONParser();
		ArrayList<ContainerObject> ret = new ArrayList<>();
		
		try {
			Reader reader = new FileReader(filePath);
            JSONObject json = (JSONObject) parser.parse(reader);
            for ( Iterator<?> iterator = json.keySet().iterator(); iterator.hasNext(); ) {
            	String key = (String) iterator.next();

            	JSONObject items = (JSONObject) json.get(key);
            	
            	ContainerObject ob = new ContainerObject( items );
            	ob.setName(key);
            	ret.add(ob);
            }
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}		
		
		return ret;
	}
	
}
