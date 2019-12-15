package saf;

public class Patient extends Person{

	public void diagnose(hospital.Patient patient) {
		System.out.println("I can't diagnose you...");		
	}	
	
	public void whatAmI() {
		System.out.println("I am Patient");
	}
}
