package models;

public abstract class PatientObjectParameters {

    protected String name;
    protected int weight;
    
    public String getName() {
    	return name;
    }

	public int getWeight() {
		return weight;
	}
	
	public static void setParameters(Object json) {
		
	}
}
