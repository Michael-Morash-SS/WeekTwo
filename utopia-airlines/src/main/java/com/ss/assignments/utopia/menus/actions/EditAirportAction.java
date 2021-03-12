/**
 * 
 */
package com.ss.assignments.utopia.menus.actions;

import java.util.Scanner;

import com.ss.assignments.utopia.menus.MenuSession;
import com.ss.assignments.utopia.models.Airport;
import com.ss.assignments.utopia.services.AirportService;
import com.ss.assignments.utopia.services.ServiceManager;

/**
 * @author Michael
 *
 */
public class EditAirportAction implements FlowMenuAction {

	@Override
	public void executeAction() {
		MenuSession session = MenuSession.getInstance();
		AirportService airportService = ServiceManager.getAirportService();
		Scanner input = ServiceManager.getScanner();
		Airport airport = session.getAirport();
		
		System.out.print("Enter new city name:");
		input.nextLine();
		String cityName = input.nextLine();
		
		airport.setCity(cityName);
		airportService.save(airport);
	}

}
