package com.ss.assignments.utopia.menus.populator;

import java.util.List;

import com.ss.assignments.utopia.menus.FlowMenu;
import com.ss.assignments.utopia.menus.FlowMenuOption;
import com.ss.assignments.utopia.menus.actions.FlowMenuAction;
import com.ss.assignments.utopia.menus.actions.SetSessionFlightAndStartMenuAction;
import com.ss.assignments.utopia.models.Airport;
import com.ss.assignments.utopia.models.Flight;
import com.ss.assignments.utopia.models.Route;
import com.ss.assignments.utopia.services.FlightService;
import com.ss.assignments.utopia.services.ServiceManager;

public class PopulateFlightList implements MenuPopulator {

	@Override
	public void populateMenu(FlowMenu menu, FlowMenu destinationMenu) {
		FlightService flightService = ServiceManager.getFlightService();
		List<Flight> flights = flightService.getFlights();
		
		for (Flight f : flights) {
			SetSessionFlightAndStartMenuAction action = new SetSessionFlightAndStartMenuAction(destinationMenu, f);
			menu.addOption(new FlowMenuOption(getRouteString(f.getRoute()), action));
		}
	}
	
	public String getRouteString(Route route) {
		return getAirportString(route.getOrigin()) + " -> " + getAirportString(route.getDestination());
	}
	
	public String getAirportString(Airport airport) {
		return airport.getIata() + ", " + airport.getCity();
	}
}
