package test.stz;

import com.stz.Screen;

public class ScreenTest {
	public static void main (String... args){
		Screen screen1 = new Screen(1);
		Screen screen2 = new Screen(2);
		Screen screen6 = new Screen(6);
		Screen screen9 = new Screen(9);
		
		System.out.println(screen1.getScreenNumber());
		System.out.println(screen1.toString());
		System.out.println(screen1.getShows());
		System.out.println(screen1.getSeats());
		System.out.println(screen1.getMovieName());
		
		System.out.println(screen2.getScreenNumber());
		System.out.println(screen2.toString());
		System.out.println(screen2.getShows());
		System.out.println(screen2.getSeats());
		System.out.println(screen2.getMovieName());
		
		System.out.println(screen6.getScreenNumber());
		System.out.println(screen6.toString());
		System.out.println(screen6.getShows());
		System.out.println(screen6.getSeats());
		System.out.println(screen6.getMovieName());
		
		System.out.println(screen9.getScreenNumber());
		System.out.println(screen9.toString());
		System.out.println(screen9.getShows());
		System.out.println(screen9.getSeats());
		System.out.println(screen9.getMovieName());
		
	}
}
