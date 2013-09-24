package com.tw;

public class Talk implements Comparable<Talk> {
	private int duration=0;
	private String name=null;

	
	
	public Talk(String name, int duration) {
		//validate for invalid duration lengths
		validateDuration(duration);
		this.duration = duration;
		this.name = name;
	}

	
	public Talk(String name, String duration) {
		//validate and convert duration
		convertDuration(duration);
		this.name=name;
	}

	

	public String getName() {
		return name;
	}

	public int getDuration() {
		return duration;
	}
	
	
	private void convertDuration(String duration)  {
		if(duration.equals("lightning")){
			this.duration = 5;
		}
		else
		{
			throw new RuntimeException("duration can only be specified as 'lightning' any other string is not allowed");
		}
	}
	
	private void validateDuration(int duration)  {

		if(duration<=0){
			throw new RuntimeException("Invalid duration");
		}
	}

	@Override
	public String toString() {
		if(duration==5){
			return getName()+" : lightning";
		}
		return getName()+" : "+getDuration()+"mins";
	}

	@Override
	public int compareTo(Talk o) {
		int res = o.getDuration()-this.getDuration();
		if(res==0){
			res=o.getName().compareTo(this.getName());
		}
		return res;	
	}
}
