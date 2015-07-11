package test.stz;

import com.stz.BookingEngine;

public class BookingEngineTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		BookingEngine bookingEngine = new BookingEngine();
		
		String inputCommand = "BOOK SCREEN5 SHOW1 3 28-APRIL-2015";
		String outputResult = bookingEngine.processCommand(inputCommand);
		System.out.println(inputCommand);
		System.out.println(outputResult);
		System.out.println("--------------------------------------------------------");
		
		inputCommand = "BOOK SCREEN6 SHOW2 10 29-APRIL-2015";
		outputResult = bookingEngine.processCommand(inputCommand);
		System.out.println(inputCommand);
		System.out.println(outputResult);
		System.out.println("--------------------------------------------------------");
		
		inputCommand = "BOOK SCREEN5 SHOW4 3 29-APRIL-2015";
		outputResult = bookingEngine.processCommand(inputCommand);
		System.out.println(inputCommand);
		System.out.println(outputResult);
		System.out.println("--------------------------------------------------------");
		
		inputCommand = "BOOK SCREEN6 SHOW2 6 11-NOVEMBER-2015";
		outputResult = bookingEngine.processCommand(inputCommand);
		System.out.println(inputCommand);
		System.out.println(outputResult);
		System.out.println("--------------------------------------------------------");
		
		inputCommand = "BOOK SCREEN6 SHOW4 3 10-MARCH-2015";
		outputResult = bookingEngine.processCommand(inputCommand);
		System.out.println(inputCommand);
		System.out.println(outputResult);
		System.out.println("--------------------------------------------------------");

		//book all tickets in screen4 6*16=96
		for(int i=0; i<17; i++){
			inputCommand = "BOOK SCREEN1 SHOW4 6 30-APRIL-2015";
			outputResult = bookingEngine.processCommand(inputCommand);
			System.out.println(inputCommand);
			System.out.println(outputResult);
			System.out.println("--------------------------------------------------------");
		}
		inputCommand = "BOOK SCREEN1 SHOW4 4 30-APRIL-2015";
		outputResult = bookingEngine.processCommand(inputCommand);
		System.out.println(inputCommand);
		System.out.println(outputResult);
		System.out.println("--------------------------------------------------------");

		inputCommand = "BOOK SCREEN1 SHOW4 2 30-APRIL-2015";
		outputResult = bookingEngine.processCommand(inputCommand);
		System.out.println(inputCommand);
		System.out.println(outputResult);
		System.out.println("--------------------------------------------------------");

		//book all tickets in screen6 6*15=90
		for(int i=0; i<15; i++){
			inputCommand = "BOOK SCREEN6 SHOW2 6 30-APRIL-2015";
			outputResult = bookingEngine.processCommand(inputCommand);
			System.out.println(inputCommand);
			System.out.println(outputResult);
			System.out.println("--------------------------------------------------------");
		}
		inputCommand = "BOOK SCREEN6 SHOW2 2 30-APRIL-2015";
		outputResult = bookingEngine.processCommand(inputCommand);
		System.out.println(inputCommand);
		System.out.println(outputResult);
		System.out.println("--------------------------------------------------------");
	}

}
