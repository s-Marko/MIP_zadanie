package models;

import java.util.ArrayList;
import java.util.Random;

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

	@SuppressWarnings("unused")
	public PatientObjectParameter generate() {
		Random rand = new Random();
		if (rand.nextDouble() <= this.chance) {
			int r = rand.nextInt(totalWeight);
			int countWeight = 0;
			for (PatientObjectParameter ob : this.list) {
				countWeight = ob.getWeight();
				if (r > ob.weight)
					return ob;
			}
		}
		// if something fails default to first element
		return this.list.get(0);
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
