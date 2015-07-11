package com.stz;

public class Seat {
	private final String rowName;
	private final int numberInRow;

	public Seat(String rowName, int numberInRow) {
		this.rowName = rowName;
		this.numberInRow = numberInRow;
	}

	public String getRowName() {
		return rowName;
	}

	public int getNumberInRow() {
		return numberInRow;
	}

	@Override
	public String toString() {
		return rowName + numberInRow;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rowName.hashCode();
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
		Seat other = (Seat) obj;
		if (numberInRow != other.numberInRow)
			return false;
		if (rowName == null) {
			if (other.rowName != null)
				return false;
		} else if (!rowName.equals(other.rowName))
			return false;
		return true;
	}

}
