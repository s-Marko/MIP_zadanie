package hospital;

import java.util.ArrayList;
import java.util.Random;

import models.ContainerObject;
import models.DiseaseOld;
import models.Disease;
import models.PatientObjectParameter;
import models.TraitOld;
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
            ArrayList<Trait> tr = this.getTraits();
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
    	for (ContainerObject tr : traitObject) {
    		if (tr != null) {
    			
    		}
    	}
        return null;
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
