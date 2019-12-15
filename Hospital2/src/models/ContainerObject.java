package models;

import java.util.ArrayList;

public class ContainerObject {

	private String name;
	private int totalWeight;
	private ArrayList<Object> list;
	
	public void generate(String path) {
		
	}
	
	public String getName() {
		return name;
	}	

	public int getTotalWeight() {
		return totalWeight;
	}
	
	public ArrayList<Object> getList() {
		return list;
	}


	public ContainerObject(String path) {
		this.generate(path);
	}
}
