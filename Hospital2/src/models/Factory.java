package models;

import org.json.simple.JSONObject;

public class Factory {
	
	public static PatientObjectParameter create(JSONObject item) {
		PatientObjectParameter ob = null;
		
		if (item.containsKey("symptoms")) { 
			ob = new Disease(); 
		}
		else { 
			ob = new Trait(); 
		}
		
		ob.setParameters(item);		
		return ob;
	}
	
}
