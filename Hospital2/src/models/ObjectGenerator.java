package models;

import java.io.FileReader;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class ObjectGenerator {
	
	public static void Generate(String[] filePath, String[]...args ) {
		
		JSONParser parser = new JSONParser();
		
		try {
			Reader reader = new FileReader("objectGenerator/disease.json");
            JSONObject json = (JSONObject) parser.parse(reader);
            
	}
	
}
