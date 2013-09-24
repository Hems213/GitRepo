package com.tw;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class MorningSession extends TalkSession {

	public MorningSession(int morningMins) {
		super.setDuration(morningMins);
		cal=new GregorianCalendar(2013,  Calendar.JANUARY, 1, 9, 0);
		cal.set(Calendar.AM_PM, Calendar.AM);
	}
	
}
