package com.tw;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TalkSession {

	private int duration = 1*60;//default 1*60
	private ArrayList<Talk> talks = new ArrayList<Talk>();
	protected GregorianCalendar cal =null;//Will be used for printing time
	private SimpleDateFormat df = new SimpleDateFormat("hh:mm a");

	public ArrayList<Talk> getTalks() {
		return talks;
	}
	
	public void addTalk(Talk tk) {
		talks.add(tk);
		//While adding a talk subtract the duration
		setDuration(duration-tk.getDuration());
	}
	
	public void removeTalk(Talk tk) {
		talks.remove(tk);
		//While removing a talk add the duration
		setDuration(duration+tk.getDuration());
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public boolean checkAddablity(Talk tk) {
		return tk.getDuration()<=this.duration;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Talk tk : getTalks()){
			sb.append("\n");
			sb.append(df.format(cal.getTime())+" - ");
			sb.append(tk.getName());
			sb.append(" : ");
			if(tk.getDuration()==5){
				sb.append("lightning");
			}else{
				sb.append(tk.getDuration());
				sb.append(" mins");
			}
			cal.add(Calendar.MINUTE, tk.getDuration());
		}
		if(getDuration()!=0){
			sb.append("\n");
			sb.append(df.format(cal.getTime())+" - ");
			sb.append("Free time : ");
			sb.append(getDuration());
			sb.append(" mins");
		}
		return sb.toString();
	}
}
