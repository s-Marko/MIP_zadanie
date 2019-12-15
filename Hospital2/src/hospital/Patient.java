package hospital;

import java.util.ArrayList;
import java.util.Random;

import models.Disease;
import models.Trait;

public class Patient extends Person{
	
	private ArrayList<Trait> traits;
    private Disease disease;
    // currently unused variable
    // TODO: implent a use
    private int health;
    
    public Disease getDisease() { return this.disease; }
    public ArrayList<Trait> getTraits() { return this.traits; }
    public int getHealth() { return this.health; }
    

    private int generateHealth() {
        int health = 80;
        if (!this.getTraits().isEmpty()) {
            ArrayList<Trait> traitList = this.getTraits();
            for (Trait trait : traitList) {
                health += trait.getModifier();
            }
        }
        return health;
    }

    // inverse CDF if exponential distrubution
    private static double inverseCDF(double rand) {
        int mean = 35;  // mean of generated values
        return -mean* Math.log(rand);
    }

    // generates age based on exponential distrubution
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
    
    public static Patient generatePatient(Disease diseaseObject, Trait traitObject) {
        return new Patient(generateAge(), diseaseObject.generateDisease(), traitObject.generateTraits());        
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
