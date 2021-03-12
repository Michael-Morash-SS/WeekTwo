/**
 * 
 */
package com.ss.assignments.utopia.menus.populator;

import java.util.List;

import com.ss.assignments.utopia.menus.FlowMenu;
import com.ss.assignments.utopia.menus.FlowMenuOption;
import com.ss.assignments.utopia.menus.actions.SetSessionAirportAndStartMenuAction;
import com.ss.assignments.utopia.menus.actions.StartMenuAction;
import com.ss.assignments.utopia.models.Airport;
import com.ss.assignments.utopia.services.AirportService;
import com.ss.assignments.utopia.services.ServiceManager;

/**
 * @author Michael
 *
 */
public class PopulateAirportList implements MenuPopulator {

	@Override
	public void populateMenu(FlowMenu menu, FlowMenu destinationMenu) {
		menu.clearOptions();
		AirportService airportService = ServiceManager.getAirportService();
		List<Airport> airports = airportService.getAirports();
		
		for (Airport a : airports) {
			menu.addOption(new FlowMenuOption(getAirportString(a), new SetSessionAirportAndStartMenuAction(destinationMenu, a)));
		}
	}
	
	public String getAirportString(Airport airport) {
		return airport.getIata() + " " + airport.getCity();
	}

}
