package models;

import java.util.ArrayList;

public class Disease2 extends PatientObjectParameters{
	
	private ArrayList<String> symptoms = new ArrayList<>();
	private ArrayList<String> messages = new ArrayList<>();
	
    public Disease2(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    

	public ArrayList<String> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(ArrayList<String> symptoms) {
		this.symptoms = symptoms;
	}

	public ArrayList<String> getMessages() {
		return messages;
	}
	
	public void setMessages(ArrayList<String> symptoms) {
		this.symptoms = symptoms;
	}
    
}
