package models;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ContainerObject {

	private String name;
	private int totalWeight;
	private ArrayList<PatientObjectParameter> list;
	
	public void generate(Object key) {
		this.list = new ArrayList<PatientObjectParameter>();
		JSONArray items = (JSONArray) key;
		for (Object item : items) {
			PatientObjectParameter ob = Factory.create((JSONObject) item);
			totalWeight += ob.getWeight();
			list.add(ob);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getTotalWeight() {
		return totalWeight;
	}
	
	public ArrayList<PatientObjectParameter> getList() {
		return list;
	}
	
	

	public ContainerObject(Object key) {
		generate(key);
	}
}
