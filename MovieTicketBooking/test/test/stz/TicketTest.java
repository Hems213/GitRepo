package test.stz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.stz.Screen;
import com.stz.Seat;
import com.stz.Show;
import com.stz.Ticket;

public class TicketTest {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		List<Seat> seats = new ArrayList<Seat>();
		seats.add(new Seat("A",1));
		seats.add(new Seat("A",3));
		seats.add(new Seat("A",2));
		seats.add(new Seat("A",4));
		
		Date bookingDate = SimpleDateFormat.getDateInstance(SimpleDateFormat.SHORT, Locale.US).parse("04/18/2015");
		Ticket testTicket = new Ticket(new Screen(2), new Show(2), seats,  bookingDate);
		
		System.out.println(testTicket);
		System.out.println(testTicket.getScreen());
		System.out.println(testTicket.getShow());
		System.out.println(testTicket.getSeats());
		System.out.println(testTicket.getScreen().getMovieName());
		System.out.println(testTicket.getDateOfBooking());
		System.out.println(testTicket.getShowDate());

	}

}
