package hospital;

public class Day {
	private String day;
	private int openingHour;
	private int closingHour;
	private Day nextDay = null;
		
	public Day nextDay() {
		return this.nextDay;
	}
	
	public void setNextDay(Day day) {
		this.nextDay = day;
	}
	
	public String getNameOfTheDay() {
		return this.day;
	}
	
	public int getOpeningHour() {
		return this.openingHour;
	}
	public int getClosingHour() {
		return this.closingHour;
	}
	
	public Day(String day, int openingHour, int closingHour) {
		this.day = day;
		this.openingHour = openingHour;
		this.closingHour = closingHour;
	}
}
