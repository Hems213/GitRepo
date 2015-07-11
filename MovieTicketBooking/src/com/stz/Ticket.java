package com.stz;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public final class Ticket {

	// A ticket once issued cannot be changed it is immutable. This class is
	// also immutable because of the semantics of ticket.
	
	private final Screen screen;
	private final Show show;
	private final List<Seat> seats = new ArrayList<Seat>();
	private final String ticketId;
	private final BigDecimal totalPrice;
	private final long timeOfBooking;
	private final Date showDate;
	
	private static AtomicLong ticketSeqNum = new AtomicLong(123400000);
	private static final DateFormat showDateFormatter = new SimpleDateFormat("dd-MMMMMM-yyyy");

	public Ticket(Screen screen, Show show, List<Seat> seatsForBooking,
			Date showDate) {
		super();

		if (seatsForBooking.size() < 1 || seatsForBooking.size() > 6 || screen==null || show==null || showDate == null) {
			throw new IllegalArgumentException("Invalid input for booking the ticket");
		}
		this.screen = screen;
		this.show = show;
		this.seats.addAll(seatsForBooking);//always copy over the inputs, holding the input's reference will make it mutable.
		this.timeOfBooking = System.currentTimeMillis();
		this.showDate = showDate;

		Collections.unmodifiableList(this.seats);// finalize the list of seats
													// because once the ticket
													// is created we should not
													// change the ticket

		this.ticketId = generateTicketId();

		this.totalPrice = computeTotalPrice();
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public Screen getScreen() {
		return screen;
	}

	public Show getShow() {
		return show;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public String getTicketId() {
		return ticketId;
	}

	private String generateTicketId() {
		String ticketId = "SC" + screen.getScreenNumber()
				+ show.getShowNumber();
		ticketId += ticketSeqNum.getAndIncrement();
		return ticketId;
	}

	private BigDecimal computeTotalPrice() {
		// Any custom logic can be implemented to caluclate price based on
		// screen show and seat chosen.
		double ttlPrice = seats.size() * 150;
		return new BigDecimal(ttlPrice);
	}

	public long getDateOfBooking() {
		return timeOfBooking;
	}

	public Date getShowDate() {
		return showDate;
	}

	@Override
	public String toString() {
		return getTicketId() + " Rs." + getTotalPrice() + " " + getSeats()
				+ " Booking confirmed for " + getScreen().getMovieName()
				+ " at " + showDateFormatter.format(getShowDate()) + " " + getShow().getShowTime() + ", "
				+ getScreen().toString();
	}

}
