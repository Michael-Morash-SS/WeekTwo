package com.ss.assignments.utopia.menus.actions;

import com.ss.assignments.utopia.menus.MenuSession;
import com.ss.assignments.utopia.models.Flight;
import com.ss.assignments.utopia.services.FlightService;
import com.ss.assignments.utopia.services.ServiceManager;

public class DeleteFlightAction implements FlowMenuAction {

	@Override
	public void executeAction() {
		Flight flight = MenuSession.getInstance().getFlight();
		FlightService flightService = ServiceManager.getFlightService();
		
		flightService.delete(flight);

	}

}
