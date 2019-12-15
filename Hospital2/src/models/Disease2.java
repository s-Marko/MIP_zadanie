package models;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Disease2 extends PatientObjectParameters{
	
	private ArrayList<String> symptoms = new ArrayList<>();
	private ArrayList<String> messages = new ArrayList<>();
	
    private Disease2(String name, int weight, ArrayList<String> messagesList, ArrayList<String> symptomsList) {
        this.name = name;
        this.weight = weight;
    }
    

	public ArrayList<String> getSymptoms() {
		return symptoms;
	}

	public ArrayList<String> getMessages() {
		return messages;
	}
	
	public static Disease2 setParameters(JSONObject item) {
		
		JSONArray messages = (JSONArray) item.get("messages");
		JSONArray symptoms = (JSONArray) item.get("symptoms");

		ArrayList<String> messagesList = new ArrayList<>();
		ArrayList<String> symptomsList = new ArrayList<>();
		
		for (Object message : messages) { messagesList.add((String) message); }		
		//for (Object symptom : symptoms) { symptomsList.add((String) symptom); }		
		
		
		Disease2 returnObject = new Disease2(
				(String )item.get("name"),
				( (Long) item.get("weight") ).intValue(),
				messagesList,
				symptomsList
				);
		
		return returnObject;
	}
    
}
