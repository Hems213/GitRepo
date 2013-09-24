package com.tw.gol;

import java.util.HashSet;

public class StartHere {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			//Imagine a infinite graph like that on a graph paper. Now enter the cordinate pairs of alive cells.
			//0,0 represents the middle of the graph and  left-down corner of the pattern
			//All those coordinates which are alive only should be given as input.
			
			//NOTE: Here this is like a graph paper. 0,0 is in center and cordinates represent the alive points in graph paper.
			HashSet<CordinatePair> ac = new HashSet<CordinatePair>();
			ac.add(new CordinatePair(1, 0));
			ac.add(new CordinatePair(0, 1));
			ac.add(new CordinatePair(2, 1));
			ac.add(new CordinatePair(0, 2));
			ac.add(new CordinatePair(1, 2));
			ac.add(new CordinatePair(3, 1));
			
			GameOfLife gol = new GameOfLife();
			HashSet<CordinatePair> resultLiveCell = gol.computeNextPattern(ac);
			
			//Printing Results
			System.out.println("The co-ordinates of graph paper for next pattern is");
			for(CordinatePair livecell : resultLiveCell){
				System.out.println(livecell);
			}
		} catch (Exception e) {
			System.out.println("Error:"+e.getMessage());
			e.printStackTrace();
		}
	}

}
