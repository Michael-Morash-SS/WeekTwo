package com.ss.assignments.utopia.menus.actions;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ss.assignments.utopia.menus.MenuSession;
import com.ss.assignments.utopia.menus.PaginatedSelectionMenu;
import com.ss.assignments.utopia.models.Airplane;
import com.ss.assignments.utopia.models.Flight;
import com.ss.assignments.utopia.models.Route;
import com.ss.assignments.utopia.services.AirplaneService;
import com.ss.assignments.utopia.services.FlightService;
import com.ss.assignments.utopia.services.InputService;
import com.ss.assignments.utopia.services.RouteService;
import com.ss.assignments.utopia.services.ServiceManager;

public class EditFlightAction implements FlowMenuAction {

	@Override
	public void executeAction() {
		Flight flight = modifyFlight();
		FlightService flightService = ServiceManager.getFlightService();
		flightService.save(flight);
	}
	
	public Flight modifyFlight() {
		Scanner input = ServiceManager.getScanner();
		InputService inputService = InputService.getInstance();
		
		FlightService flightService = ServiceManager.getFlightService();
		RouteService routeService = ServiceManager.getRouteService();
		AirplaneService airplaneService = ServiceManager.getAirplaneService();
		
		int flowInput = 0;
		boolean updateFinished = false;
		
		List<Route> routeList = routeService.getRoutes();
		List<Airplane> airplaneList = airplaneService.getAirplanes();
		
		PaginatedSelectionMenu<Route> selectRoute = new PaginatedSelectionMenu<Route>("Select route", input, routeList);
		PaginatedSelectionMenu<Airplane> selectAirplane = new PaginatedSelectionMenu<Airplane>("Select airplane", input, airplaneList);
		
		CreateRouteAction newRoutePrompt = new CreateRouteAction();
		CreateAirplaneAction newAirplanePrompt = new CreateAirplaneAction();
		
		Flight flight = MenuSession.getInstance().getFlight();
		Route updatedRoute = null;
		Airplane updatedAirplane = null;
		LocalDateTime updatedDeparture = null;
		Float updatedSeatPrice = null;
		
		do {
			try {
				System.out.println("Select route: ");
				System.out.println("1) Use current route " + flight.getRoute().toString());
				System.out.println("2) Select existing route");
				System.out.println("3) Create new route");
				System.out.print("Input: ");
				flowInput = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Error: Expecting input from given options");
				input.nextLine();
				continue;
			}
			
			if (flowInput == 1) {
				updateFinished = true;
			} else if (flowInput == 2) {
				updatedRoute = selectRoute.start();
				if (updatedRoute != null) {
					updateFinished = true;
				}
			} else if (flowInput == 3) {
				updatedRoute = newRoutePrompt.createRoutePrompt();
				if (updatedRoute != null) {
					updateFinished = true;
				}
			} else {
				System.out.println("Error: Expecting input from given options");
			}
		} while (!updateFinished);
		
		updateFinished = false;
		
		do {
			try {
				System.out.println("Select airplane: ");
				System.out.println("1) Use current plane " + flight.getAirplane().toString());
				System.out.println("2) Select existing airplane");
				System.out.println("3) Create new airplane");
				System.out.print("Input: ");
				flowInput = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Error: Expecting input from given options");
				input.nextLine();
				continue;
			}
			
			if (flowInput == 1) {
				updateFinished = true;
			} else if (flowInput == 2) {
				updatedAirplane = selectAirplane.start();
				if (updatedAirplane != null) {
					updateFinished = true;
				}
			} else if (flowInput == 3) {
				updatedAirplane = newAirplanePrompt.createAirplanePrompt();
				if (updatedAirplane != null) {
					updateFinished = true;
				}
			} else {
				System.out.println("Error: Expecting input from given options");
			}
		} while (!updateFinished);
		
		updateFinished = false;
		
		do {
			try {
				System.out.println("Select departure time: ");
				System.out.println("1) Use current time " + flight.getDeparture().toString());
				System.out.println("2) Set new time");
				System.out.print("Input: ");
				flowInput = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Error: Expecting input from given options");
				input.nextLine();
				continue;
			}
			
			if (flowInput == 1) {
				updateFinished = true;
			} else if (flowInput == 2) {
				updatedDeparture = inputService.getDateTimeInput("Enter new departure time: ");
				updateFinished = true;
			} else {
				System.out.println("Error: Expecting input from given options");
			}
		} while(!updateFinished);
		
		updateFinished = false;
		
		do {
			try {
				System.out.println("Select seat price: ");
				System.out.println("1) Use current price " + flight.getSeatPrice().toString());
				System.out.println("2) Set new price");
				System.out.print("Input: ");
				flowInput = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Error: Expecting input from given options");
				input.nextLine();
				continue;
			}
			
			if (flowInput == 1) {
				updateFinished = true;
			} else if (flowInput == 2) {
				try {
					System.out.print("Enter new seat price: ");
					updatedSeatPrice = input.nextFloat();
					updateFinished = true;
				} catch (InputMismatchException e) {
					System.out.println("Error: Expecting seat price");
					input.nextLine();
					continue;
				}
			} else {
				System.out.println("Error: Expecting input from given options");
			}
		} while (!updateFinished);
		
		if (updatedRoute != null) {
			flight.setRoute(updatedRoute);
		}
		
		if (updatedAirplane != null) {
			flight.setAirplane(updatedAirplane);
		}
		
		if (updatedDeparture != null) {
			flight.setDeparture(updatedDeparture);
		}
		
		if (updatedSeatPrice != null) {
			flight.setSeatPrice(updatedSeatPrice);
		}
		
		return flight;
	}

}
