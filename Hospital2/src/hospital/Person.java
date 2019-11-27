package hospital;

import java.util.Random;

import com.github.javafaker.Faker;

public class Person {
	private String firstName;
	private String middleName = "";
	private String lastName;
	private int age;
	
    public int getAge() { return this.age; }
    
    public String getName() { 
    	if ( middleName != "" )
    		return (this.firstName + " " +  this.middleName + " " + this.lastName);
    	return (this.firstName + " " + this.lastName); 
    }
    
    public String getFirstName() {
    	return this.firstName;
    }
    
    public void interact(Person person) {
    	;
    }
    
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
            this.middleName = faker.name().firstName();
        this.age = age;
    }
	
	
}
