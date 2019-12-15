package hospital;

import java.util.ArrayList;
import java.util.Random;

import models.ContainerObject;
import models.Disease;
import models.Trait;

public class Patient extends Person{
	
	private ArrayList<Trait> traits;
    private Disease disease;
    private int health;
    
    public Disease getDisease() { return this.disease; }
    public ArrayList<Trait> getTraits() { return this.traits; }
    public int getHealth() { return this.health; }
    
    
    private int generateHealth() {
        int health = 80;
        if (!this.getTraits().isEmpty()) {
            ArrayList<Trait> tr= this.getTraits();
            for (Trait trait : tr) {
                health += trait.getModifier();
            }
        }
        return health;
    }

    private static double inverseCDF(double rand) {
        int mean = 35;
        return -mean* Math.log(rand);
    }

    private static int generateAge() {
        Random random = new Random();
        int min = 19;
        double age, y;
        do {
            y = random.nextDouble();
            age = inverseCDF(y) + min;
        }while(age > 85);

        return (int)Math.floor(age);
    }
    
    public static Patient generatePatient(ArrayList<ContainerObject> diseaseObject, ArrayList<ContainerObject> traitObject) {
        //return new Patient(generateAge(), containerObject.generateDisease(), traitObject.generateTraits());
    	return null;
    }
    
    private Patient(int age, Disease disease, ArrayList<Trait> traits) {
        super(generateAge());
        this.disease = disease;
        this.traits = traits;
        this.health = generateHealth();
    }
	@Override
	public void interact(Object o) {
		/// this method should never get called
		System.out.println("I can't interact with anything...");
	}    
}
