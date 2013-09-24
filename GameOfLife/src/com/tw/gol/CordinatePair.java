package com.tw.gol;

import java.util.HashSet;
/*
 *  Cordinate pair is the cordinates of the cell. This identifies the cell uniquely. So it can also be called as cell. 
 * */
public class CordinatePair {
	private int x;
	private int y;
	
	public CordinatePair(int x, int y) {
		super();
		validate(x);
		validate(y);
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		validate(x);
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		validate(y);
		this.y = y;
	}
	
	private void validate(int a) {
		if(Integer.MAX_VALUE<a||a<Integer.MIN_VALUE){
			throw new RuntimeException("cordinates cannot have more than "+(Integer.MAX_VALUE-5)+" or "+(Integer.MIN_VALUE+5));
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CordinatePair other = (CordinatePair) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	public HashSet<CordinatePair> getSurroundingCordinates() {
		HashSet<CordinatePair> sc = new HashSet<CordinatePair>(8);
		sc.add(new CordinatePair(x+1, y+1));
		sc.add(new CordinatePair(x+1, y+0));
		sc.add(new CordinatePair(x+1, y-1));
		sc.add(new CordinatePair(x+0, y-1));
		sc.add(new CordinatePair(x-1, y-1));
		sc.add(new CordinatePair(x-1, y+0));
		sc.add(new CordinatePair(x-1, y+1));
		sc.add(new CordinatePair(x+0, y+1));
		return sc;
	}
	
	@Override
	public String toString() {
		return "("+this.getX()+","+this.getY()+")";
	}
	
	
}
