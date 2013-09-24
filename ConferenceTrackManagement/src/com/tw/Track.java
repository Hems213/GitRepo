package com.tw;

public class Track {
	
	private MorningSession morning = null;
	private EveningSession evening = null;
	
	public Track(int morningMins, int eveningMins) {
		morning = new MorningSession(morningMins);
		evening = new EveningSession(eveningMins);
	}
	public MorningSession getMorning() {
		return morning;
	}
	public void setMorning(MorningSession morning) {
		this.morning = morning;
	}
	public EveningSession getEvening() {
		return evening;
	}
	public void setEvening(EveningSession evening) {
		this.evening = evening;
	}

	@Override
	public String toString() {
		StringBuilder otpt = new StringBuilder();
		otpt.append(getMorning().toString());
		otpt.append("\n");
		otpt.append("12:00 PM - Lunch");
		otpt.append(getEvening().toString());
		return otpt.toString();
	}
}
