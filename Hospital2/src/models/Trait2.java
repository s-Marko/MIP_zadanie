package models;

import org.json.simple.JSONObject;

public class Trait2 extends PatientObjectParameter{
	
	public Trait2() {
		super();
	}

	private int modifier;
    
    public int getModifier() {
    	return modifier;
    }
    
    @Override
    public void setParameters(JSONObject item) {
        this.name = (String )item.get("name");
        this.weight = ( (Long) item.get("weight") ).intValue();
        this.modifier = ( (Long) item.get("modifier") ).intValue();
    }
    
}
