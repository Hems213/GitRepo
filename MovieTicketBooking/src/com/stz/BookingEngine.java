package com.stz;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class BookingEngine{
	//Ideally, a booking Engine should be injected as a singleton via a framework. 
	
	private final List<Ticket> ticketsDataBase = new ArrayList<Ticket>();
	private final DateFormat showDateFormatter = new SimpleDateFormat("dd-MMMMMM-yyyy");

	private Ticket bookTicket(Screen screen, Show show, Date showDate, int numberOfSeats) throws Exception {
		validateShowDate(showDate);

		List<Seat> seats = allocateNewSeats(screen, show, showDate,	numberOfSeats);
		Ticket newTicket = new Ticket(screen, show, seats, showDate);
		getTicketsDataBase().add(newTicket);
		return newTicket;
	}

	private  List<Seat> allocateNewSeats(Screen screen, Show show, Date showDate, int numberOfSeats) throws Exception {
		validateShowInScreen(screen, show);
		List<Seat> availableSeats = new ArrayList<Seat>(screen.getSeats());//nneds to have a copy because the screen's seats is meta data and should not be meddled with.
		List<Seat> occupiedSeats = findOccupiedSeats(screen, show, showDate);
		availableSeats.removeAll(occupiedSeats);
		if(availableSeats.size()>=numberOfSeats){
			return new ArrayList<Seat>(availableSeats.subList(0, numberOfSeats));
		}else{
			throw new Exception("Sorry, "+ numberOfSeats+" seats are not available for the requested screen "+screen.getScreenNumber()+" for show "+show.getShowNumber()+". Please try other screens");
		}
		
	}

	private  List<Seat> findOccupiedSeats(Screen screen, Show show, Date showDate) {
		List<Seat> occupiedSeats = new ArrayList<Seat>();
		for (Ticket tkt : getTicketsDataBase()) {
			if(tkt.getScreen().equals(screen)
					&& tkt.getShow().equals(show)
					&& tkt.getShowDate().equals(showDate)){
				occupiedSeats.addAll(tkt.getSeats());
			}
		}
		return occupiedSeats;
	}

	private  void validateShowInScreen(Screen screen, Show show) throws Exception {
		List<Show> showsInScreen = screen.getShows();
		if(!showsInScreen.contains(show)){
			throw new Exception("Sorry, there is no such show in the screen "+screen);
		}
	}

	private  void validateShowDate(Date showDate) {
		Calendar maxBookingDate = GregorianCalendar.getInstance();
		maxBookingDate.add(Calendar.DAY_OF_MONTH, 7);
		if (showDate.after(maxBookingDate.getTime())) {
			throw new IllegalArgumentException("Booking can only be done till "
					+ getShowDateFormatter().format(maxBookingDate.getTime()));
		}
		if (showDate.before(Calendar.getInstance().getTime())) {
			throw new IllegalArgumentException("Booking cannot be done for date in the past");
		}
	}
	
	protected List<Ticket> getTicketsDataBase() {
		return ticketsDataBase;
	}

	protected DateFormat getShowDateFormatter() {
		return showDateFormatter;
	}

	public  String processCommand(String inputCommand) {
		String[] inputs = inputCommand.split(" ");
		//validate inputs
		if(inputs.length != 5){
			return "Invalid inputs";
		}
		String command = inputs[0];
		if(!command.toUpperCase().equals("BOOK")){
			return "Invalid Command";
		}
		
		String screen = inputs[1];
		Integer screenNumber = null; 
		if(screen.matches("^SCREEN\\d{1,2}$")){
			screenNumber = Integer.parseInt(screen.replaceAll("SCREEN", ""));
		}else {
			return "Invalid screen";
		}
		
		String show = inputs[2];
		Integer showNumber = null;
		if(show.matches("^SHOW\\d$")){
			showNumber = Integer.parseInt(show.replaceAll("SHOW", ""));
		}else {
			return "Invalid show";
		}
		
		String numberOfTickets = inputs[3];
		Integer numOfTickets = null;
		if(numberOfTickets.matches("^\\d+$")){
			numOfTickets = Integer.parseInt(numberOfTickets);
			if(numOfTickets<1 || numOfTickets>6){
				return "Number of Tickets can be between 1 to 6";
			}
		}else {
			return "Invalid number of tickets";
		}
		
		String dateOfShow = inputs[4];
		Date showDate = null;
		
		try{
			showDate = getShowDateFormatter().parse(dateOfShow);
		}catch(Exception e){
			return "Invalid date format";
		}
		
		//All basic format validation has passed
		Ticket resultTicket;
		try {
			resultTicket = bookTicket(new Screen(screenNumber), new Show(showNumber), showDate, numOfTickets);
		} catch (Exception e) {
			return e.getMessage();
		}
		
		return resultTicket.toString();
	}
	
}
