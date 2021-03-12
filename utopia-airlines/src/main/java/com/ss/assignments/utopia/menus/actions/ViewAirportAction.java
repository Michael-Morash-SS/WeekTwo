/**
 * 
 */
package com.ss.assignments.utopia.menus.actions;

import com.ss.assignments.utopia.menus.MenuSession;
import com.ss.assignments.utopia.models.Airport;

/**
 * @author Michael
 *
 */
public class ViewAirportAction implements FlowMenuAction {

	@Override
	public void executeAction() {
		MenuSession session = MenuSession.getInstance();
		Airport airport = session.getAirport();
		
		System.out.println("IATA: " + airport.getIata());
		System.out.println("City: " + airport.getCity());
	}

}
