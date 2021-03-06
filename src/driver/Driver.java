/**
 * 
 */
package driver;
import java.io.IOException;
import java.util.Scanner;
import java.util.Collections;

import airplane.Airplane;
import airport.Airport;
import airport.Airports;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import dao.ServerInterface;
import flight.Flight;
import flight.Flights;
import airplane.Airplanes;

/**
 * @author blake
 *
 */
public class Driver {

	/**
	 * Entry point for CS509 sample code driver
	 * 
	 * This driver will retrieve the list of airports from the CS509 server and print the list 
	 * to the console sorted by 3 character airport code
	 * 
	 * @param args is the arguments passed to java vm in format of "CS509.sample teamName" where teamName is a valid team
	 */

	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("usage: CS509.sample teamName");
			System.exit(-1);
			return;
		}



		String teamName = args[0];

		UserInput ui = new UserInput();
		String code = ui.getAirportCode();
		//String code = args[1];
		String date = ui.getDeparturedate();
		//String date = args[2];
		//Try to get a list of airports
		//Airports airports = ServerInterface.INSTANCE.getAirports(teamName);
		//Collections.sort(airports);
		//for (Airport airport : airports) {
			//System.out.println(airport.toString());
		//}
		
		Flights departflights = ServerInterface.INSTANCE.getDepartingFlights(teamName, code, date);
		for (Flight departflight : departflights) {
			System.out.println(departflight.toString());}
		

		//Flights arrivalflights = ServerInterface.INSTANCE.getArrivingFlights(teamName, code, date);
		//for (Flight arrivalflight : arrivalflights) {
			//System.out.println(arrivalflight.toString());}

		//Airplanes airplanes = ServerInterface.INSTANCE.getAirplanes(teamName);
		//Collections.sort(airplanes);
		//for (Airplane airplane : airplanes) {
			//System.out.println(airplane.toString());


		String flightnumber = ui.getFlightNumber();

		System.out.println("Desired flight number: \r");
		System.out.println(flightnumber);



		}

	}




