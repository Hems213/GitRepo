package com.tw;


import java.util.ArrayList;
import java.util.Collections;


public class TimeSlotter {

	private ArrayList<Track> tracks = new ArrayList<Track>();// for storing the tracks
	private int morningMins;
	private int eveningMins;
	

	public TimeSlotter(int morningMins, int eveningMins){
		
		//Configuration info for the class, morning and evening duration are kept as configurable.
		this.morningMins = morningMins;
		this.eveningMins = eveningMins;
	}

	
	public String allocateSlots(ArrayList<Talk> input_talks) {
		
		//Validate the input_talks
		validateInput(input_talks);
		
		//compute Total time
		int totalTime = computeTotalTime(input_talks);
		
		//First sort the talks based on duration
		sortInputTalks(input_talks);
		
		//Get minimum number of tracks required - total hours / max. mins per day
		double minTrack = Math.ceil(new Double(totalTime).doubleValue()/(morningMins+eveningMins));
		
		//Create a new trackmanager one time. The track manager takes care of fitting a talk into a track.It also creates tracks with given morning and evening duration
		//Isolating the tasks of track management to a separate class thorugh this track manager
		TrackManager tm = new TrackManager(morningMins, eveningMins);
		
		
		//Creating a list with minimum number of tracks needed. Can be added to whenever required.
		//This  step of creating tracks is optional. It will work even without this step but its better to add the minimum tracks before starting
		for(int i=0;i<minTrack;i++){
			tracks.add(tm.createTrack());
		}
		
		//Start fitting each talk into a track
		for(Talk tk : input_talks){
			
			//Adds into exisiting tracks if possible. Otherwise creates a new track and adds it to the tracks.
			boolean success = tm.fitaTalk(tracks, tk);
			
			//Error check. If it is not able to fit a talk, then some problem exisits
			if(!success){
				throw new RuntimeException("This should not be happening!! Unable to fit a talk to a track. Something went wrong during allocation!");
			}
		}
		
		//Printing some infos
		System.out.println("\n ADDITIONAL INFO \n");
		System.out.println("Total time of the given inputs is : "+ totalTime);
		System.out.println("Theoritical Minimum required tracks (totaltime/"+(morningMins+eveningMins)+") approx: "+minTrack);
		System.out.println("Total number of tracks used : "+tracks.size());
		
		//tracks object contains the output. printable track method can be changed to print json/xml if needed.
		StringBuilder sb = formatOutPut(tracks);
		return sb.toString();
		
		
	}

	

	private void validateInput(ArrayList<Talk> input_talks) {
		// Creating it as a separate method instead of clubbing with another method for better maintainablity.
		if(input_talks.size()<1){
			throw new RuntimeException("atleast one talk should be added. Talks cannot be zero");
		}
		for(Talk tk: input_talks){
			if(tk.getDuration()>morningMins){
				throw new RuntimeException("talk cannot exceed a duration of a session ("+this.morningMins+" mins):"+tk.toString());
			}
		}
	}

	//Can change this printable method alone to xml or json or any form as needed for output formatting.
	//In case we need to return the output in an object based form instead of string ,
	//we can even modify this method to run throught the tracks  and take needed output and create the output object
	//to send it to the user. The user can use that output object's api to programatically access the outputs.
	//Presently the need is to construct a string, so this method just builds the stringnuilder.
	private StringBuilder formatOutPut(ArrayList<Track> tracks2) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<tracks.size();i++){
			Track trk = tracks.get(i);
			sb.append("\n----------------------\n");
			sb.append("Track"+(i+1));
			sb.append("\n----------------------\n");
			sb.append(trk);
		}
		return sb;
	}

	//This is made public method as it can be used as a utility method to compute total in future.
	public int computeTotalTime(ArrayList<Talk> input_talks) {
		int total = 0;
		for(Talk tk : input_talks){
			total+=tk.getDuration();
		}
		return total;
	}

	private void sortInputTalks(ArrayList<Talk> input_talks) {
		//Sort the entry set using a compartor and collections
		Collections.sort(input_talks);
		
		// Input after sorting
//		System.out.println("\nAfter sorting the input is:");
//		for (Talk tk1 : input_talks) {
//			System.out.println(tk1);
//		}
	}

}
