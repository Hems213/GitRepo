package com.tw.gol;

import java.util.HashSet;

public class GameOfLife {
	//Cells should not repeat in a list, so using lists all over.
	HashSet<CordinatePair> livingcells=null;
	HashSet<CordinatePair> nextSetLivingCell=new HashSet<CordinatePair>();

	public HashSet<CordinatePair> computeNextPattern(HashSet<CordinatePair> seed) {
		this.livingcells = seed;
		
		//First collect all cells that could be affected by given living cells and store it in a set.
		//all surrounding cells of the given cells have possiblity to come alive, since for a cell to come alive it needs 
		//atleast one cell in its neighbourhood.
		HashSet<CordinatePair> allImpactableCells = collectAllImpactableCells(livingcells);
		
		//for each impactable cell find if the cell is alive or not. If it is alive cell push into nextSet else skip it.
		for(CordinatePair cell : allImpactableCells){
			boolean isCellAlive = computeLifeOfCell(cell);
			if(isCellAlive){
				nextSetLivingCell.add(cell);
			}
		}
		
		return nextSetLivingCell;
	}

	private boolean computeLifeOfCell(CordinatePair cell) {
		//This method computes the life of a cell based on its neighbour cells and the rules.
		//First compute the number of live cells around a given cell.
		//We use intersection of sets to compute the number of living cells around a cell. 
		HashSet<CordinatePair> neighbourcells = cell.getSurroundingCordinates();
		
		//Eliminate all neighboring dead cells to collect only neighboring living cells. 
		neighbourcells.retainAll(livingcells);
		
		//Compute the number of living neighbor cells.
		int numberOfLivingCells = neighbourcells.size();
		
		//Check the rules
		//Rules for live cells
		/*
		 * 1.Live cell with greated than 3 or less than 2 dies
		 * 2.if it is equal to 2 or 3 it lives on
		 * */
		if(livingcells.contains(cell)){
			if(numberOfLivingCells>3 || numberOfLivingCells<2){
				return false;
			}else{
				return true;
			}
		}
		//Rules for dead cells
		//3. Dead cell with exactly 3 comes to life. All others die.
		else{
			if(numberOfLivingCells==3){
				return true;
			}else{
				return false;
			}
		}
	}

	private HashSet<CordinatePair> collectAllImpactableCells(HashSet<CordinatePair> livingcells2) {
		HashSet<CordinatePair> allImpactableCells = new HashSet<CordinatePair>();
		for(CordinatePair livingcell : livingcells2){
			HashSet<CordinatePair> surroundingcells = livingcell.getSurroundingCordinates();
			allImpactableCells.addAll(surroundingcells);
		}
		allImpactableCells.addAll(livingcells);
		return allImpactableCells;
	}
	
	
}
