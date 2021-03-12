/**
 * 
 */
package com.ss.assignments.utopia.menus.actions;

import java.util.List;
import java.util.Scanner;

import com.ss.assignments.utopia.menus.PaginatedSelectionMenu;
import com.ss.assignments.utopia.models.Flight;
import com.ss.assignments.utopia.models.FlightSeat;
import com.ss.assignments.utopia.services.FlightService;
import com.ss.assignments.utopia.services.InputService;
import com.ss.assignments.utopia.services.ServiceManager;

/**
 * @author Michael
 *
 */
public class CreateSeatAction implements FlowMenuAction {

	@Override
	public void executeAction() {
		FlightService flightService = ServiceManager.getFlightService();
		FlightSeat seats = createSeatPrompt();
		flightService.saveSeat(seats);
	}
	
	public FlightSeat createSeatPrompt() {
		Scanner input = ServiceManager.getScanner();
		InputService inputService = InputService.getInstance();
		
		FlightService flightService = ServiceManager.getFlightService();
		List<Flight> flightList = flightService.getFlights();
		PaginatedSelectionMenu<Flight> flightSelection = new PaginatedSelectionMenu<Flight>("Select flight: ", input, flightList);
		
		FlightSeat flightSeat = new FlightSeat();
		Flight flight = null;
		
		do {
			flight = flightSelection.start();
		} while (flight == null);

		input.nextLine();
		flightSeat.setFlight(flight);
		flightSeat.setSeatType(inputService.getStringInput("Enter seat type: "));
		flightSeat.setAmount(inputService.getIntInput("Enter amount of seats: "));
		
		return flightSeat;
	}

}
