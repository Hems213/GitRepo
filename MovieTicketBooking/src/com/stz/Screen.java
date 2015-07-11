package com.stz;

import java.util.ArrayList;
import java.util.List;

public class Screen {
	private int screenNumber;
	private List<Show> shows = new ArrayList<Show>();
	private List<Seat> seats = new ArrayList<Seat>();
	private String movieName;

	public Screen(int screenNumber) {
		this.screenNumber = screenNumber;

		shows.add(new Show(1));
		shows.add(new Show(2));
		shows.add(new Show(3));
		if (!(this.screenNumber == 5 || this.screenNumber == 9)) {
			shows.add(new Show(4));
		}

		if (this.screenNumber == 6) {
			String[] rows = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
					"K", "L", "M", "N", "O" };
			int seatsPerRow = 6;
			initSeats(rows, seatsPerRow);
		} else {
			String[] rows = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
			int seatsPerRow = 10;
			initSeats(rows, seatsPerRow);
		}

		if (this.screenNumber <= 5) {
			this.movieName = "The Best";
		} else {
			this.movieName = "Awesome";
		}
	}

	public int getScreenNumber() {
		return screenNumber;
	}

	public List<Show> getShows() {
		return shows;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	// In case if we need to dynamically add or remove seats or shows, we can
	// use below logic to implement that functionality
/*
	public void addSeat(Seat seat) {
		if (seats.contains(seat)) {
			throw new IllegalArgumentException("Seat already exists");
		}
		seats.add(seat);
	}

	public void removeSeat(Seat seat) {
		if (seats.contains(seat)) {
			seats.remove(seat);
		} else {
			throw new IllegalArgumentException("No such seat");
		}
	}

	public void addShow(Show show) {
		if (shows.contains(show)) {
			throw new IllegalArgumentException("Seat already exists");
		}
		shows.add(show);
	}

	public void removeShow(Seat show) {
		if (shows.contains(shows)) {
			shows.remove(shows);
		} else {
			throw new IllegalArgumentException("No such seat");
		}
	}
*/
	private void initSeats(String[] rows, int seatsPerRow) {
		for (String row : rows) {
			for (int i = 1; i <= seatsPerRow; i++) {
				seats.add(new Seat(row, i));
			}
		}
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	@Override
	public String toString() {
		return "Screen " + this.screenNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + screenNumber;
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
		Screen other = (Screen) obj;
		if (screenNumber != other.screenNumber)
			return false;
		return true;
	}
}
