package models;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Disease2 extends PatientObjectParameter{
	
	private ArrayList<String> symptoms;
	private ArrayList<String> messages;
	
    public Disease2() {
    	super();
    }
    
    
	public ArrayList<String> getSymptoms() { return symptoms; }
	public ArrayList<String> getMessages() { return messages; }
	
	
	public void setParameters(JSONObject item) {
		
		JSONArray messages = (JSONArray) item.get("messages");
		JSONArray symptoms = (JSONArray) item.get("symptoms");

		ArrayList<String> messagesList = new ArrayList<>();
		ArrayList<String> symptomsList = new ArrayList<>();
		
		for (Object message : messages) { messagesList.add((String) message); }		
		for (Object symptom : symptoms) { symptomsList.add((String) symptom); }		
		
		this.name = (String )item.get("name");
		this.weight = ( (Long) item.get("weight") ).intValue();
		this.messages = messagesList;
		this.symptoms = symptomsList;
	}
    
}
