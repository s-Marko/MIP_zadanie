package hospital;

public class Timer extends Thread{
	
	private Day day;
	private int interval;
	private int time;
	private boolean run = false;
	private World world;
	
	public synchronized boolean isRunning() {
		return run;
	}
	
	public synchronized void setRunning(boolean running) {
		this.run = running;
	}
	
	public synchronized void setDay(Day day) {
		if (!run) {
			this.day = day;
			int duration = day.getClosingHour() - day.getOpeningHour();
			this.time = duration * 60;
			this.interval = 5;
		}
		else {
			System.out.println("You shouldn't see this.");
		}
	}
	
	public void run() {
		System.out.println(this.day.getNameOfTheDay() + " is starting.");
		while(this.getTime() > 0) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.out.println(this.time);
			this.time -= this.interval;
		}
		System.out.println("The day is ending.");
		setRunning(false);
	}

	public synchronized int getTime() {
		return this.time;
	}
	
	public Timer(World world) {
		this.world = world;
	}
}
