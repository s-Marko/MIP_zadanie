package models;

public class Event {
	public static void fireEvent(String string) throws InterruptedException {
		// Sends messages with delay; should rework or delete
		int timer = 1;
		try {
			System.out.println(string);
			Thread.sleep(timer * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}