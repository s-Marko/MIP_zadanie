package main.java;

import java.util.ArrayList;

import hospital.World;
import models.ContainerObject;
import models.ObjectGenerator;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		//World world = new World();
		
		//world.start();
		//ContainerObject t = new ContainerObject("objectGenerator/disease.json");
		ArrayList<ContainerObject> o = ObjectGenerator.generate("objectGenerator/traits.json");
		System.out.println(o.get(0).getList());
	}
}
