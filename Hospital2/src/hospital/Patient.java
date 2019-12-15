package hospital;

import java.util.ArrayList;
import java.util.Random;

import models.ContainerObject;
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
            ArrayList<Trait> tr = this.getTraits();
            for (Trait trait : tr) {
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
    
    public Patient(ContainerObject containerObject, ArrayList<ContainerObject> traitObject) {
        super(generateAge());
        this.traits = new ArrayList<Trait>();
        for (ContainerObject tr : traitObject) {
        	Trait t = (Trait) tr.generate();
        	if (t != null) { this.traits.add(t); }
    	}
        
        this.disease = (Disease) containerObject.generate();        
        this.health = generateHealth();
    }
    
	@Override
	public void interact(Object o) {
		/// this method should never get called
		System.out.println("I can't interact with anything...");
	}    
}
