package main.java;

import java.util.ArrayList;

import hospital.World;
import models.ContainerObject;
import models.ObjectGenerator;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		World world = new World();
		
		world.start();
		/*ArrayList<ContainerObject> o = ObjectGenerator.generate("objectGenerator/disease.json");
		System.out.println(o.get(0).getList().get(0).getName());*/
	}
}
