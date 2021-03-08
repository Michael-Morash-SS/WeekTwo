package com.ss.assignments.utopia.menus.actions;

import com.ss.assignments.utopia.menus.FlowMenu;
import com.ss.assignments.utopia.menus.MenuSession;
import com.ss.assignments.utopia.models.Flight;

public class SetSessionFlightAndStartMenuAction implements FlowMenuAction {
	MenuSession session;
	FlowMenu menu;
	Flight flight;
	
	public SetSessionFlightAndStartMenuAction(FlowMenu menu, Flight flight) {
		this.session = MenuSession.getInstance();
		this.menu = menu;
		this.flight = flight;
	}
	
	@Override
	public void executeAction() {
		session.setFlight(flight);
		
		menu.start();
	}
}
