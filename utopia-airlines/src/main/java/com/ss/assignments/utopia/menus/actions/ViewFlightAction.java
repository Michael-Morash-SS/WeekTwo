package com.ss.assignments.utopia.menus.actions;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.ss.assignments.utopia.menus.MenuSession;
import com.ss.assignments.utopia.models.Airport;
import com.ss.assignments.utopia.models.Flight;
import com.ss.assignments.utopia.services.ServiceManager;

public class ViewFlightAction implements FlowMenuAction {

	@Override
	public void executeAction() {
		Scanner input = ServiceManager.getScanner();
		MenuSession session = MenuSession.getInstance();
		Flight flight = session.getFlight();
		StringBuffer output = new StringBuffer();
		
		output.append("You have chosen to view the Flight with Flight Id: ")
			.append(flight.getId())
			.append(" and Departure Airport: ")
			.append(getAirportString(flight.getRoute().getOrigin()))
			.append(" and Arrival Airport: ")
			.append(getAirportString(flight.getRoute().getDestination()))
			.append("\n");
		
		output.append("Departure Airport: ").append(getAirportString(flight.getRoute().getOrigin()))
			.append(" | ")
			.append("Arrival Airport: ").append(getAirportString(flight.getRoute().getDestination()))
			.append(" | ")
			.append("Departure Date: ").append(flight.getDeparture().format(DateTimeFormatter.ISO_DATE))
			.append(" | ")
			.append("Departure Date: ").append(flight.getDeparture().format(DateTimeFormatter.ISO_TIME))
			.append("\n");
		
		output.append("Seats by Class:\n");
		output.append("1) First - X\n");
		output.append("2) Business - Y\n");
		output.append("3) Economy - Z");
		
		System.out.println(output.toString());
		System.out.println();
		System.out.println("Press enter to continue");
		input.nextLine();
		input.nextLine();
	}
	
	private String getAirportString(Airport airport) {
		return airport.getIata() + ", " + airport.getCity();
	}

}
