package saf;

public class Doctor extends Person{

	public void diagnose(hospital.Patient patient) {
		System.out.println(patient.getFirstName() + " has " + patient.getDisease());		
	}
	
	public void whatAmI() {
		System.out.println("I am doctor.");
	}
}
