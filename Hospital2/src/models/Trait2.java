package models;

import org.json.simple.JSONObject;

public class Trait2 extends PatientObjectParameters{
	
	private int modifier;
	
    private Trait2(String name, int weight, int modifier) {
        this.name = name;
        this.weight = weight;
        this.modifier = modifier;
    }
    
    public int getModifier() {
    	return modifier;
    }
    
    
	public static Trait2 setParameters(JSONObject item) {		
		
		Trait2 returnObject = new Trait2(
				(String )item.get("name"),
				( (Long) item.get("weight") ).intValue(),
				( (Long) item.get("modifier") ).intValue()
				);
		
		return returnObject;
	}
    
}
