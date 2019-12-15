package models;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class DiseaseOld {
    private String name;
    private int weight;
    private int combinedWeight = 0;
    private ArrayList<DiseaseOld> diseases = new ArrayList<DiseaseOld>();


    public DiseaseOld generateDisease() {
        Random random = new Random();
        int r = random.nextInt(combinedWeight);
        for (DiseaseOld disease: diseases) {
            if (r > disease.weight)
                return disease;
        }
        return diseases.get(0);
    }

    public String getName() {
        return this.name;
    }

    //// Main constructor, reads information from external JSON file and generates Objects into private arrayList. 
    public DiseaseOld() {
    	JSONParser parser = new JSONParser();
        try {
            Reader reader = new FileReader("objectGenerator/disease.json");
            JSONObject json = (JSONObject) parser.parse(reader);
            JSONArray diseaseJson = (JSONArray) json.get("disease");
            for (Object value : diseaseJson) {
            	JSONObject o = (JSONObject) value;
            	int oWeight = ((Long)o.get("weight")).intValue();
            	diseases.add(new DiseaseOld( (String)o.get("name"), oWeight ) );
            	combinedWeight += oWeight;
            }
            
          


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private DiseaseOld(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
}
