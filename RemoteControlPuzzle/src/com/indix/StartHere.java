package com.indix;

import java.util.ArrayList;

public class StartHere {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Inputs here
		
		
		//test case1
		int start_channel = 1;
		int end_channel = 20;
		ArrayList<Integer> blocked_list=new ArrayList<Integer>();
		blocked_list.add(18);
		blocked_list.add(19);
		ArrayList<Integer> desired_list = new ArrayList<Integer>();
		desired_list.add(15);
		desired_list.add(14);
		desired_list.add(17);
		desired_list.add(1);
		desired_list.add(17);
		Inputs inpts = new Inputs(start_channel, end_channel, blocked_list, desired_list);

		//test case2
		int start_channel1 = 103;
		int end_channel1 = 108;
		ArrayList<Integer> blocked_list1=new ArrayList<Integer>();
		blocked_list1.add(104);
		ArrayList<Integer> desired_list1 = new ArrayList<Integer>();
		desired_list1.add(105);
		desired_list1.add(106);
		desired_list1.add(107);
		desired_list1.add(103);
		desired_list1.add(105);
		Inputs inpts1 = new Inputs(start_channel1, end_channel1, blocked_list1, desired_list1);

		//test case3
		int start_channel2 = 1;
		int end_channel2 = 100;
		ArrayList<Integer> blocked_list2=new ArrayList<Integer>();
		blocked_list2.add(78);
		blocked_list2.add(79);
		blocked_list2.add(80);
		blocked_list2.add(3);
		ArrayList<Integer> desired_list2 = new ArrayList<Integer>();
		desired_list2.add(10);
		desired_list2.add(13);
		desired_list2.add(13);
		desired_list2.add(100);
		desired_list2.add(99);
		desired_list2.add(98);
		desired_list2.add(77);
		desired_list2.add(81);
		Inputs inpts2 = new Inputs(start_channel2, end_channel2, blocked_list2, desired_list2);
		
		//testcase4
		int start_channel3 = 1;
		int end_channel3 = 200;
		ArrayList<Integer> blocked_list3=new ArrayList<Integer>();
		ArrayList<Integer> desired_list3 = new ArrayList<Integer>();
		desired_list3.add(1);
		desired_list3.add(100);
		desired_list3.add(1);
		desired_list3.add(101);
		Inputs inpts3 = new Inputs(start_channel3, end_channel3, blocked_list3, desired_list3);
		
		
		ClickCounter cc = new ClickCounter();

		//Printing outputs
		int num_clicks = cc.findMinimumNumberOfClicks(inpts);
		System.out.println("Minimum Number of clicks for testcase1 : "+ num_clicks);
		System.out.println("==============================================");

		num_clicks = cc.findMinimumNumberOfClicks(inpts1);
		System.out.println("Minimum Number of clicks for testcase2 : "+ num_clicks);
		System.out.println("==============================================");
		
		num_clicks = cc.findMinimumNumberOfClicks(inpts2);
		System.out.println("Minimum Number of clicks for testcase3 : "+ num_clicks);
		System.out.println("==============================================");
		
		num_clicks = cc.findMinimumNumberOfClicks(inpts3);
		System.out.println("Minimum Number of clicks for testcase4 : "+ num_clicks);
		System.out.println("==============================================");
	}

}
class Inputs{
	private int start_channel;// = 1;
	private int end_channel;// = 20;
	private ArrayList<Integer> blocked_list;//=new ArrayList<Integer>();
	private ArrayList<Integer> desired_list;// = new ArrayList<Integer>();
	public Inputs(int start_channel, int end_channel, ArrayList<Integer> blocked_list, ArrayList<Integer> desired_list) {
		validateInputs(start_channel, end_channel, blocked_list,desired_list);
		this.start_channel = start_channel;
		this.end_channel = end_channel;
		this.blocked_list = blocked_list;
		this.desired_list = desired_list;
	}
	
	public ArrayList<Integer> getBlocked_list() {
		return blocked_list;
	}
	public ArrayList<Integer> getDesired_list() {
		return desired_list;
	}
	public int getStart_channel() {
		return start_channel;
	}
	public int getEnd_channel() {
		return end_channel;
	}

	//Input validation
	private void validateInputs(int start_channel2, int end_channel2,
			ArrayList<Integer> blocked_list2, ArrayList<Integer> desired_list2) {
		if(!(0<start_channel2&& start_channel2<=10000)){
			throw new RuntimeException("invalid lowest channel");
		}
		if(!(start_channel2<end_channel2 && end_channel2<=10000)){
			throw new RuntimeException("Invalid end channel");
		}
		if(blocked_list2.size()>40){
			throw new RuntimeException("blockedlist cant go more than 40");
		}
		if(!(1<desired_list2.size()&&desired_list2.size()<50)){
			throw new RuntimeException("invalid desired list of channels");
		}
		for(Integer channel : blocked_list2){
			validateChannel(start_channel2, end_channel2, channel);
			if(desired_list2.contains(channel)){
				throw new RuntimeException("desired channel list cannot contain blocked channels");
			}
		}
		for(Integer channel : desired_list2){
			validateChannel(start_channel2, end_channel2, channel);
		}
	}

	private void validateChannel(int start_channel2, int end_channel2,
			Integer channel) {
		if(!(start_channel2<=channel.intValue() && channel.intValue()<=end_channel2)){
			throw new RuntimeException("Invalid channel in blocked/desired channels list");
		}
	}

	

}
