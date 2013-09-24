package com.indix;

import java.util.ArrayList;

public class ClickCounter {

	private ArrayList<Integer> channels;
	
	public int findMinimumNumberOfClicks(Inputs inpts) {
		int result=0;
		//Populate the channels in an array list
		channels = new ArrayList<Integer>();
		for(int i=inpts.getStart_channel();i<=inpts.getEnd_channel();i++){
			channels.add(i);
		}
		//Remove all blocked channels from list of channels. It behaves as if those channels dont exist
		channels.removeAll(inpts.getBlocked_list());

		//Create local copies 
		ArrayList<Integer> desired_channels = inpts.getDesired_list();
		int desiredChannelsSize = desired_channels.size();
		
		//Clicks to navigate to first channel
		if(desired_channels.get(0).intValue() != 1){//Assuming that channels start from 1. 
			result = desired_channels.get(0).toString().length();
		}
//		System.out.println("Computing clicks to "+desired_channels.get(0));
//		System.out.println(result);
		//Further navigation
		for(int j=0; j<desiredChannelsSize-1; j++){
			Integer from_channel = desired_channels.get(j);
			Integer to_channel = desired_channels.get(j+1);
			Integer previous_channel = null;
			if(j>0){
				previous_channel = desired_channels.get(j-1);
			}
			
			result+=computeMinimumNoOfClick(from_channel, to_channel, previous_channel);
		}
		return result;
	}

	private int computeMinimumNoOfClick(Integer from_channel, Integer to_channel, Integer previous_channel) {
		int result=0;
//		System.out.println("Computing clicks from "+from_channel+" to "+to_channel);

		if(from_channel.equals(to_channel)){
//			System.out.println("Using Direct number input");
			result = 0;
//			System.out.println(result);
			return result;
		}
		
		//Clicks using back if applicable
		if(previous_channel!=null && previous_channel.equals(to_channel)){
//			System.out.println("Using back button");
			result=1;
//			System.out.println(result);
			return result;
		}
		
		//Clicks for direct input
		int clicksForDirectNumInpt = to_channel.toString().length();
		
		//Clicks for using step inpt using up and down buttons
		int clockwiseDiff = Math.abs(channels.indexOf(to_channel)-channels.indexOf(from_channel));
		int antiClockwiseDiff = Math.abs(channels.size()-clockwiseDiff);
		int clicksForStepInpt = Math.min(clockwiseDiff, antiClockwiseDiff);
		result = Math.min(clicksForDirectNumInpt, clicksForStepInpt);

//		if(clicksForStepInpt<clicksForDirectNumInpt){
////			System.out.println("Using up or down button");
//		}else{
////			System.out.println("Using direct number");
//		}
//		System.out.println(result);
		return result;
	}

}
