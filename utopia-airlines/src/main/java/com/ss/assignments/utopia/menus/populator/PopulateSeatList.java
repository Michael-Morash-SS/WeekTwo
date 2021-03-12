package com.ss.assignments.utopia.menus.populator;

import java.util.List;

import com.ss.assignments.utopia.menus.FlowMenu;
import com.ss.assignments.utopia.menus.FlowMenuOption;
import com.ss.assignments.utopia.menus.actions.SetSessionSeatsAndStartMenuAction;
import com.ss.assignments.utopia.models.FlightSeat;
import com.ss.assignments.utopia.services.FlightService;
import com.ss.assignments.utopia.services.ServiceManager;

public class PopulateSeatList implements MenuPopulator {

	@Override
	public void populateMenu(FlowMenu menu, FlowMenu destinationMenu) {
		FlightService flightService = ServiceManager.getFlightService();
		List<FlightSeat> seatList = flightService.getSeats();
		
		for (FlightSeat s : seatList) {
			menu.addOption(new FlowMenuOption(getSeatString(s), new SetSessionSeatsAndStartMenuAction(s, destinationMenu)));
		}
	}
	
	public String getSeatString(FlightSeat seat) {
		return "Flight id " + seat.getFlight().getId() + ": " + seat.getAmount() + " " + seat.getSeatType();
	}

}
