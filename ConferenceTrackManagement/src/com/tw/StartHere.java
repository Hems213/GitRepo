package com.tw;

import java.util.ArrayList;

public class StartHere {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//Initializes the input to the program and calls allocate method to start allocation
			//Input is hardcoded here. 
			ArrayList<Talk> input_talks = new ArrayList<Talk>();
			
			
//			Sample test input
			input_talks.add(new Talk("Writing Fast Tests Against Enterprise Rails", 44));
			input_talks.add(new Talk("Overdoing it in Python", 14));
			input_talks.add(new Talk("Lua for the Masses", 32));
			input_talks.add(new Talk("Ruby Errors from Mismatched Gem Version", 49));
			input_talks.add(new Talk("Common Ruby Errors", 56));
			input_talks.add(new Talk("Rails for Python Developers", "lightning"));
			input_talks.add(new Talk("Communicating Over Distance", 17));
			input_talks.add(new Talk("Accounting-Driven Development", 60));
			input_talks.add(new Talk("Woah", 33));
			input_talks.add(new Talk("Sit Down and Write", 36));
			input_talks.add(new Talk("Pair Programming vs Noise", 48));
			input_talks.add(new Talk("Rails Magic", 28));
			input_talks.add(new Talk("Ruby on Rails: Why We Should Move On", 55));
			input_talks.add(new Talk("Clojure Ate Scala (on my project)", 49));
			input_talks.add(new Talk("Programming in the Boondocks of Seattle", 53));
			input_talks.add(new Talk("Programming in the DeepThoughs of New", 62));
			input_talks.add(new Talk("Programming in the GreatWoods of Nowhere", 32));
			input_talks.add(new Talk("Ruby vs. Clojure for Back-End Development", 51));
			input_talks.add(new Talk("Ruby on Rails Legacy App Maintenance", 43));
			input_talks.add(new Talk("A World Without HackerNews", 16));
			input_talks.add(new Talk("User Interface CSS in Rails Apps", 38));
			input_talks.add(new Talk("Power of object oriented programing", "lightning"));

//			Given test input
//			input_talks.add(new Talk("Writing Fast Tests Against Enterprise Rails", 60));
//			input_talks.add(new Talk("Overdoing it in Python", 45));
//			input_talks.add(new Talk("Lua for the Masses", 30));
//			input_talks.add(new Talk("Ruby Errors from Mismatched Gem Version", 45));
//			input_talks.add(new Talk("Common Ruby Errors", 45));
//			input_talks.add(new Talk("Rails for Python Developers", "lightning"));
//			input_talks.add(new Talk("Communicating Over Distance", 60));
//			input_talks.add(new Talk("Accounting-Driven Development", 45));
//			input_talks.add(new Talk("Woah", 30));
//			input_talks.add(new Talk("Sit Down and Write", 30));
//			input_talks.add(new Talk("Pair Programming vs Noise", 45));
//			input_talks.add(new Talk("Rails Magic", 60));
//			input_talks.add(new Talk("Ruby on Rails: Why We Should Move On", 60));
//			input_talks.add(new Talk("Clojure Ate Scala (on my project)", 45));
//			input_talks.add(new Talk("Programming in the Boondocks of Seattle", 30));
//			input_talks.add(new Talk("Ruby vs. Clojure for Back-End Development", 30));
//			input_talks.add(new Talk("Ruby on Rails Legacy App Maintenance", 60));
//			input_talks.add(new Talk("A World Without HackerNews", 30));
//			input_talks.add(new Talk("User Interface CSS in Rails Apps", 30));
			
			
			//Construc the TimeSlotter with morning and evening session as configuration for constructor.
			//Evening session duration is assumed to be till 5 o clock ,so 4 hours. If there is any free time in evening session, networking event can overlap into it.
			int morningDuration = 3*60;
			int eveningDuration = 4*60;
			TimeSlotter ts = new TimeSlotter(morningDuration , eveningDuration);
			
			System.out.println("Given Input is : ");
			for(Talk tk : input_talks){
				System.out.println(tk);
			}
			
			System.out.println("Morning Duration : "+ morningDuration+" mins");
			System.out.println("Evening Duration : "+ eveningDuration+" mins");
			
			//main  method call and get output string
			String result = ts.allocateSlots(input_talks);
			
			//Print the result
			System.out.println("\n\n\n OUTPUT \n\n\n");
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		
	}

}
