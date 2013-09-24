package com.tw;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class EveningSession extends TalkSession {
	
	public EveningSession(int eveningMins) {
		super.setDuration(eveningMins);
		cal=new GregorianCalendar(2013,  Calendar.JANUARY, 1, 1, 0);
		cal.set(Calendar.AM_PM, Calendar.PM);
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		
		//Finally put a networking event depending on the end time
		if(cal.get(Calendar.HOUR_OF_DAY)>=16){
			sb.append("\n05:00 PM - Networking Event");
		}else{
			sb.append("\n04:00 PM - Networking Event");
		}
		return sb.toString();
	}
	
}
