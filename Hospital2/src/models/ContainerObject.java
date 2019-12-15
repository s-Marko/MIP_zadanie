package models;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ContainerObject {

	private String name;
	private int totalWeight;
	private double chance;
	private ArrayList<PatientObjectParameter> list;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getTotalWeight() {
		return totalWeight;
	}

	public double getChance() {
		return chance;
	}
	
	public ArrayList<PatientObjectParameter> getList() {
		return list;
	}	

	public void generate() {
		
	}
	
	public ContainerObject(JSONObject key) {
		this.list = new ArrayList<PatientObjectParameter>();
		this.chance = (double) key.get("chance");
		
		JSONArray content = (JSONArray) key.get("content");
		for (Object item : content) {
			PatientObjectParameter ob = Factory.create((JSONObject) item);
			totalWeight += ob.getWeight();
			list.add(ob);
		}
	}
}
