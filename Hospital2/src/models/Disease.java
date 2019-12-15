package models;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Disease {
    private String name;
    private int weight;
    private int combinedWeight = 0;
    private ArrayList<Disease> diseases = new ArrayList<Disease>();


    public Disease generateDisease() {
        Random random = new Random();
        int r = random.nextInt(combinedWeight);
        for (Disease disease: diseases) {
            if (r > disease.weight)
                return disease;
        }
        return diseases.get(0);
    }

    public String getName() {
        return this.name;
    }

    //// Main constructor, reads information from external JSON file and generates Objects into private arrayList. 
    public Disease() {
    	JSONParser parser = new JSONParser();
        try {
            Reader reader = new FileReader("objectGenerator/disease.json");
            JSONObject json = (JSONObject) parser.parse(reader);
            JSONArray diseaseJson = (JSONArray) json.get("disease");
            for (Object value : diseaseJson) {
            	JSONObject valueInstance = (JSONObject) value;
            	int valueInstanceWeight = ((Long)o.get("weight")).intValue();
            	diseases.add(new Disease( (String)o.get("name"), valueInstanceWeight ) );
            	combinedWeight += valueInstanceWeight;
            } 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Disease(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
}
