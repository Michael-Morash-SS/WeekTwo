/**
 * 
 */
package com.ss.assignments.utopia.menus.actions;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ss.assignments.utopia.menus.PaginatedSelectionMenu;
import com.ss.assignments.utopia.models.Airport;
import com.ss.assignments.utopia.models.Route;
import com.ss.assignments.utopia.services.AirportService;
import com.ss.assignments.utopia.services.RouteService;
import com.ss.assignments.utopia.services.ServiceManager;

/**
 * @author Michael
 *
 */
public class CreateRouteAction implements FlowMenuAction {

	@Override
	public void executeAction() {
		// TODO Auto-generated method stub

	}
	
	public Route createRoutePrompt() {
		Scanner input = ServiceManager.getScanner();
		AirportService airportService = ServiceManager.getAirportService();
		
		int flowInput;
		
		CreateAirportAction newAirportPrompt = new CreateAirportAction();
		
		List<Airport> airportList = airportService.getAirports();
		
		PaginatedSelectionMenu<Airport> selectAirport = new PaginatedSelectionMenu<>("Select Airport:", input, airportList);
		
		Route newRoute = new Route();
		Airport origin = null;
		Airport destination = null;
		
		System.out.println("Creating new route");
		
		do {
			System.out.println("Select origin:");
			System.out.println("1) Create new airport");
			System.out.println("2) Use existing");
			System.out.print("Input: ");
			
			try {
				flowInput = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Error: Expecting input from given options");
				input.nextLine();
				continue;
			}
			
			if (flowInput == 1) {
				origin = newAirportPrompt.createAirportPrompt();
			} else {
				origin = selectAirport.start();
			}
		} while (origin == null);
		
		do {
			System.out.println("Select destination:");
			System.out.println("1) Create new airport");
			System.out.println("2) Use existing");
			System.out.print("Input: ");
			
			try {
				flowInput = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Error: Expecting input from given options");
				input.nextLine();
				continue;
			}
			
			if (flowInput == 1) {
				destination = newAirportPrompt.createAirportPrompt();
			} else {
				destination = selectAirport.start();
			}
		} while (destination == null);
		
		newRoute.setOrigin(origin);
		newRoute.setDestination(destination);
		
		System.out.println("Created new route");
		
		return newRoute;
	}

}
