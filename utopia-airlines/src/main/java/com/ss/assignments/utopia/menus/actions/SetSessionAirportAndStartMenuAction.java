/**
 * 
 */
package com.ss.assignments.utopia.menus.actions;

import com.ss.assignments.utopia.menus.FlowMenu;
import com.ss.assignments.utopia.menus.MenuSession;
import com.ss.assignments.utopia.models.Airport;

/**
 * @author Michael
 *
 */
public class SetSessionAirportAndStartMenuAction implements FlowMenuAction {
	private MenuSession session;
	private FlowMenu menu;
	private Airport airport;
	
	public SetSessionAirportAndStartMenuAction(FlowMenu menu, Airport airport) {
		session = MenuSession.getInstance();
		this.menu = menu;
		this.airport = airport;
	}

	@Override
	public void executeAction() {
		session.setAirport(airport);
		menu.start();
	}

}
