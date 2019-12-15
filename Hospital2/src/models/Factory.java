package models;

import org.json.simple.JSONObject;

public class Factory {
	
	public static PatientObjectParameter create(JSONObject item) {
		PatientObjectParameter ob = null;
		
		if (item.containsKey("symptoms")) { ob = new Disease2(); }
		else { ob = new Trait2(); }
		
		ob.setParameters(item);
		
		return ob;
	}
	
}
