/**
 * 
 */
package com.ss.assignments.utopia.menus.actions;

import com.ss.assignments.utopia.menus.FlowMenu;
import com.ss.assignments.utopia.menus.MenuSession;
import com.ss.assignments.utopia.models.FlightSeat;

/**
 * @author Michael
 *
 */
public class SetSessionSeatsAndStartMenuAction implements FlowMenuAction {
	private FlightSeat seat;
	private FlowMenu menu;
	
	public SetSessionSeatsAndStartMenuAction(FlightSeat seat, FlowMenu menu) {
		this.seat = seat;
		this.menu = menu;
	}

	@Override
	public void executeAction() {
		MenuSession session = MenuSession.getInstance();
		session.setFlightSeat(seat);
		menu.start();
	}

}
