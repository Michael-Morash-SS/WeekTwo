package com.ss.assignments.utopia.menus.actions;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ss.assignments.utopia.menus.PaginatedSelectionMenu;
import com.ss.assignments.utopia.models.Airplane;
import com.ss.assignments.utopia.models.Flight;
import com.ss.assignments.utopia.models.Route;
import com.ss.assignments.utopia.services.AirplaneService;
import com.ss.assignments.utopia.services.FlightService;
import com.ss.assignments.utopia.services.RouteService;
import com.ss.assignments.utopia.services.ServiceManager;

public class CreateFlightAction implements FlowMenuAction {
	public void executeAction() {
		FlightService flightService = ServiceManager.getFlightService();
		Flight flight = createFlightPrompt();
		
		flightService.save(flight);
	}
	
	public Flight createFlightPrompt() {
		Scanner input = ServiceManager.getScanner();
		
		FlightService flightService = ServiceManager.getFlightService();
		RouteService routeService = ServiceManager.getRouteService();
		AirplaneService airplaneService = ServiceManager.getAirplaneService();
		
		int flowInput;
		
		List<Route> routeList = routeService.getRoutes();
		List<Airplane> airplaneList = airplaneService.getAirplanes();
		
		PaginatedSelectionMenu<Route> selectRoute = new PaginatedSelectionMenu<Route>("Select route", input, routeList);
		PaginatedSelectionMenu<Airplane> selectAirplane = new PaginatedSelectionMenu<Airplane>("Select airplane", input, airplaneList);
		
		CreateRouteAction newRoutePrompt = new CreateRouteAction();
		CreateAirplaneAction newAirplanePrompt = new CreateAirplaneAction();
		
		Flight newFlight = new Flight();
		Route route = null;
		Airplane airplane = null;
		Integer departureYear = null;
		Integer departureMonth = null;
		Integer departureDay = null;
		Integer departureHour = null;
		Integer departureMinute = null;
		Float seatPrice = null;
		
		System.out.println("Creating new flight");
		
		do {
			System.out.println("Select route:");
			System.out.println("1) Create new route");
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
				route = newRoutePrompt.createRoutePrompt();
			} else {
				route = selectRoute.start();
			}
		} while (route == null);

		do {
			System.out.println("Select airplane:");
			System.out.println("1) Create new airplane");
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
				airplane = newAirplanePrompt.createAirplanePrompt();
			} else {
				airplane = selectAirplane.start();
			}
		} while (airplane == null);
		
		do {
			try {
				System.out.print("Departure Year: ");
				departureYear = input.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Error: Expecting integer input");
				input.nextLine();
			}
		} while(departureYear == null);
		
		do {
			try {
				System.out.print("Departure Month: ");
				departureMonth = input.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Error: Expecting integer input");
				input.nextLine();
				continue;
			}
			
			if (departureMonth < 1 || departureMonth > 12) {
				System.out.println("Error: Expecting number between 1 and 12");
				departureMonth = null;
			}
		} while(departureMonth == null);
		
		do {
			try {
				System.out.print("Departure Day: ");
				departureDay = input.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Error: Expecting integer input");
				input.nextLine();
				continue;
			}
			
			if (departureDay < 1 || departureDay > Month.of(departureMonth).maxLength()) {
				System.out.println("Error: Expecting number between 1 and " + Month.of(departureMonth).maxLength());
				departureDay = null;
			}
		} while(departureDay == null);
		
		do {
			try {
				System.out.print("Departure Hour: ");
				departureHour = input.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Error: Expecting integer input");
				input.nextLine();
				continue;
			}
			
			if (departureHour < 0 || departureHour > 23) {
				System.out.println("Error: Expecting number between 0 and 23");
				departureHour = null;
			}
		} while(departureHour == null);
		
		do {
			try {
				System.out.print("Departure Minute: ");
				departureMinute = input.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Error: Expecting integer input");
				input.nextLine();
				continue;
			}
			
			if (departureMinute < 0 || departureMinute > 59) {
				System.out.println("Error: Expecting number between 0 and 59");
				departureMinute = null;
			}
		} while(departureMinute == null);
		
		do {
			try {
				System.out.print("Seat Price: ");
				seatPrice = input.nextFloat();
			} catch(InputMismatchException e) {
				System.out.println("Error: Expecting float input");
				input.nextLine();
			}
		} while (seatPrice == null);
		
		newFlight.setRoute(route);
		newFlight.setAirplane(airplane);
		newFlight.setDeparture(LocalDateTime.of(departureYear, departureMonth, departureDay, departureHour, departureMinute));
		newFlight.setSeatPrice(seatPrice);
		
		System.out.println("New flight created");
		
		return newFlight;
	}
}
