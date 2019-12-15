package models;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Disease2 extends PatientObjectParameters{
	
	private ArrayList<String> symptoms;
	private ArrayList<String> messages;
	
    private Disease2(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    
    private void setMessages(ArrayList<String> messages) { this.messages = messages; }
    private void setSymptoms(ArrayList<String> symptoms) { this.symptoms = symptoms; }
    
	public ArrayList<String> getSymptoms() { return symptoms; }
	public ArrayList<String> getMessages() { return messages; }
	
	
	public static Disease2 setParameters(JSONObject item) {
		
		JSONArray messages = (JSONArray) item.get("messages");
		JSONArray symptoms = (JSONArray) item.get("symptoms");

		ArrayList<String> messagesList = new ArrayList<>();
		ArrayList<String> symptomsList = new ArrayList<>();
		
		for (Object message : messages) { messagesList.add((String) message); }		
		for (Object symptom : symptoms) { symptomsList.add((String) symptom); }		
		
		
		Disease2 returnObject = new Disease2(
				(String )item.get("name"),
				( (Long) item.get("weight") ).intValue()
				);
		returnObject.setMessages(messagesList);
		returnObject.setSymptoms(symptomsList);
		
		return returnObject;
	}
    
}
