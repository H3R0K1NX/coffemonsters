package Airports;

public class Flight {
	private String name;
	private String destination;
	private static int code = 100000;
	private Time time;

	public Flight(String name, String destination, int hour, int minute) {
		this.name = name;
		this.destination = destination;
		time = new Time(hour, minute);
		code++;
	}

	public String getName() {
		return name;
	}

	public String getFlightDestination() {
		return destination;
	}

	public int getFlightCode() {
		return code;
	}

	public Time getFlightTime() {
		return time;
	}

	@Override
	public String toString() {
		String str = "Flight number : " + code + "\n" + "The flight company : " + name + "\n" + "Flying to : "
				+ destination + "\n" + "Departs at : " + time;
		return str;
	}

}
