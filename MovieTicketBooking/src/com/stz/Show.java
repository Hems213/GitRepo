package com.stz;

public class Show {
	private final int showNumber;
	// should have been a Joda 'LocalTime' class,
	// but since I dont know weather to use thirdparty library,
	// sticking with string based hack.. Should convert to proper Joda/Java8 Time class according to environment.
	private final String showTime;

	public int getShowNumber() {
		return showNumber;
	}

	public String getShowTime() {
		return showTime;
	}


	public Show(int showNumber) {
		this.showNumber = showNumber;
		if (showNumber == 1) {
			this.showTime = "12:30 PM";
		} else if (showNumber == 2) {
			this.showTime = "3:30 PM";
		} else if (showNumber == 3) {
			this.showTime = "6:30 PM";
		} else if (showNumber == 4) {
			this.showTime = "10:00 PM";
		} else {
			throw new IllegalArgumentException("Not a valid show number"
					+ showNumber);
		}
	}

	@Override
	public String toString() {
		return "Show " + showNumber + ", time=" + showTime;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + showNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Show other = (Show) obj;
		if (showNumber != other.showNumber)
			return false;
		return true;
	}
}
