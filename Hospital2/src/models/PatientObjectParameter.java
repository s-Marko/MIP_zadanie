package models;

import org.json.simple.JSONObject;

public abstract class PatientObjectParameter {

    protected String name;
    protected int weight;

	public String getName() {
    	return name;
    }

	public int getWeight() {
		return weight;
	}
	
	public void setParameters(JSONObject item) {
	}
	
	public PatientObjectParameter() {
	}
}
