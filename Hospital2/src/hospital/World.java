package hospital;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import models.ContainerObject;
import models.Disease;
import models.Trait;

public class World extends Thread{
	private ArrayList<Patient> patients = new ArrayList<>();
	private Patient activePatient;
	private Doctor doctor;
	private ContainerObject diseaseObject;
	private Trait traitObject;
	
	boolean running = true;
	
	private Day week = null;
	
	private Timer timer;

	public Patient getActivePatient() {
		return this.activePatient;
	}

	public void setActivePatient(Patient activePatient) {
		this.activePatient = this.patients.get(0);
		this.removePatient(this.activePatient);
	}
	
	public ArrayList<Patient> patients() {
		return this.patients;
	}
	
	public ContainerObject getDiseaseObject() {
		return this.diseaseObject;
	}
	
	public Trait getTraitObject() {
		return this.traitObject;
	}
	
	public Doctor doctor() {
		return this.doctor;
	}
	
	public void addPatient() {
		this.patients.add(Patient.generatePatient(getDiseaseObject(), getTraitObject()));
	}
	
	private void removePatient(Patient patient) {
		this.patients.remove(patient);
	}
	
	public Day getWeek() {
		return this.week;
	}
	
	private void initializeWeek() {
		Day temp = null;
		try {
			Scanner scanner = new Scanner(new FileReader("objectGenerator/days.txt"));
			while(scanner.hasNextLine()) {
				String[] days = scanner.nextLine().split(",");
				if (this.week == null) {
					temp = new Day(days[0], Integer.parseInt(days[1]), Integer.parseInt(days[2]));
					this.week = temp;
				}
				else {
					temp.setNextDay(new Day(days[0], Integer.parseInt(days[1]), Integer.parseInt(days[2])));
					temp = temp.nextDay();
				}
			}
			temp.setNextDay(this.week);
			scanner.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		Random rand = new Random();
		while (running) {
			this.timer = new Timer(this);
			this.timer.setDay(this.week);
			this.timer.setRunning(true);
			this.timer.start();
			while (this.timer.isRunning()) {
				try {
					if (rand.nextDouble() > 0.4) {
						this.addPatient();
					}
					if (!this.patients().isEmpty()) {
						Patient activePatient = this.patients().get(0);
						this.doctor().diagnose(activePatient);
						this.removePatient(activePatient);
					}					
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.week = this.week.nextDay();
		}
	}
	
	
	public World() {
		initializeWeek();
		//this.diseaseObject = new ContainerObject();
		this.traitObject = new Trait();
		this.patients = new ArrayList<Patient>();
		this.doctor = new Doctor();
		this.timer = new Timer(this);
		this.timer.setDay(this.week);
	}

}
