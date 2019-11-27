package hospital;

import java.util.Random;

import models.Event;

public class Doctor extends Person{

	public Doctor() {
		super(55);
	}
	
	public void diagnose(Patient patient) throws InterruptedException {
		Random random = new Random();
		Event.fireEvent("Doctor is starting to diagnose " + patient.getName() + ".");
		Event.fireEvent(patient.getName() + " is diagnosed with " + patient.getDisease().getName() + ".");
		switch(patient.getDisease().getName()) {
			case "Hepatitis":
				Event.fireEvent("It doesn't look good.");		
				Event.fireEvent("Doctor can't do anything right now and reffered " + patient.getFirstName() + " to specialist.");
				break;
			case "Common cold":
				Event.fireEvent("Doctor advises to rest in bed and drink lots of water.");
				if (random.nextDouble() > 0.4) {
					Event.fireEvent("It looks like " + patient.getFirstName() + " coughs a lot.");
					Event.fireEvent("Doctor prescribed " + patient.getFirstName() + " medication to ease the cough.");
				}
				break;
			case "Inflamed tonsils":
				Event.fireEvent("Doctor prescribed " + patient.getFirstName() + " antibacterial medicine.");
				break;
			case "Chicken pox":
				Event.fireEvent(patient.getFirstName() + " Should lie in bed for a few days");
				break;
		}		
		Event.fireEvent(patient.getFirstName() + " is leaving the ambulance.");
		System.out.println("");
	}
}
