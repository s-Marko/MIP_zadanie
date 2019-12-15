package main.java;

import hospital.World;
import models.ContainerObject;
import models.ObjectGenerator;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		//World world = new World();
		
		//world.start();
		ObjectGenerator.generate("objectGenerator/traits.json", new String[]{"test", "test2"});
		//ContainerObject t = new ContainerObject("objectGenerator/disease.json");
	}
}
