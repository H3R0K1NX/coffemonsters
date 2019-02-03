package Airports;

public class Time {
	private int hour;
	private int minute;

	public Time(int hour, int minute) {
		if (hour >= 0 && hour < 24)
			this.hour = hour;
		else
			this.hour = 0;
		if (minute < 60 && minute >= 0)
			this.minute = minute;
		else {
			if (minute > 60) {
				while (minute > 60) {
					minute -= 60;
					if (hour + 1 < 23)
						hour++;
					else
						hour = 0;
				}
				this.minute = minute;
			} else if (minute > -60) {
				if (hour == 0)
					hour = 23;
				else
					hour--;
				this.minute = 60 - minute;
			} else
				while (minute < -60) {
					minute += 60;
					if (hour - 1 > 0)
						hour--;
					else
						hour = 23;
				}
			this.minute = 60 - minute;
		}
	} // End of constructor

}
