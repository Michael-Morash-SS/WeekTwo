/**
 * 
 */
package com.ss.assignments.utopia.menus.actions;

import com.ss.assignments.utopia.menus.MenuSession;
import com.ss.assignments.utopia.services.AirportService;
import com.ss.assignments.utopia.services.ServiceManager;

/**
 * @author Michael
 *
 */
public class DeleteAirportAction implements FlowMenuAction {

	@Override
	public void executeAction() {
		AirportService airportService = ServiceManager.getAirportService();
		MenuSession session = MenuSession.getInstance();
		
		airportService.delete(session.getAirport());
	}

}
