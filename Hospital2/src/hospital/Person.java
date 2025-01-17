package hospital;

import java.util.Random;
import com.github.javafaker.Faker;

interface Diagnose {
	void diagnose(Patient patient) throws InterruptedException;
}

abstract class Person {
	private String firstName;
	private String middleName = "";
	private String lastName;
	private int age;
	
    public final int getAge() { return this.age; }
    
    public final String getName() { 
    	if ( middleName != "" )
    		return (this.firstName + " " +  this.middleName + " " + this.lastName);
    	return (this.firstName + " " + this.lastName); 
    }
    
    public String getFirstName() {
    	return this.firstName;
    }
    
    public abstract void interact(Object o);
    
    public boolean equals(Object o) {
		if (o == null) return false;
		if (o == this) return true;
		if (!(o instanceof Patient)) return false;
		return false;
	}
	
	public Person(int age) {
    	Faker faker = new Faker();
    	Random random = new Random();
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        if (random.nextDouble() > 0.950)
			// generates middle name with a 1/20 chance
            this.middleName = faker.name().firstName();
        this.age = age;
    }
	
}
