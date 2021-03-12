package com.ss.assignments.utopia.services;

import java.util.Scanner;

public class ServiceManager {
	private static volatile Scanner input;
	private static volatile AirportService airportService;
	private static volatile FlightService flightService;
	private static volatile RouteService routeService;
	private static volatile AirplaneService airplaneService;
	private static volatile AirplaneTypeService airplaneTypeService;
	private static volatile UserService userService;
	
	public static Scanner getScanner() {
		if (input == null) {
			synchronized(ServiceManager.class) {
				if (input == null) {
					input = new Scanner(System.in);
				}
			}
		}
		
		return input;
	}

	public static AirportService getAirportService() {
		if (airportService == null) {
			synchronized(ServiceManager.class) {
				if (airportService == null) {
					airportService = new AirportService();
				}
			}
		}
		
		return airportService;
	}
	
	public static FlightService getFlightService() {
		if (flightService == null) {
			synchronized(ServiceManager.class) {
				if (flightService == null) {
					flightService = new FlightService();
				}
			}
		}
		
		return flightService;
	}
	
	public static RouteService getRouteService() {
		if (routeService == null) {
			synchronized(ServiceManager.class) {
				if (routeService == null) {
					routeService = new RouteService();
				}
			}
		}
		
		return routeService;
	}
	
	public static AirplaneService getAirplaneService() {
		if (airplaneService == null) {
			synchronized(ServiceManager.class) {
				if (airplaneService == null) {
					airplaneService = new AirplaneService();
				}
			}
		}
		
		return airplaneService;
	}
	
	public static AirplaneTypeService getAirplaneTypeService() {
		if (airplaneTypeService == null) {
			synchronized(ServiceManager.class) {
				if (airplaneTypeService == null) {
					airplaneTypeService = new AirplaneTypeService();
				}
			}
		}
		
		return airplaneTypeService;
	}
	
	public static UserService getUserService() {
		if (userService == null) {
			synchronized(ServiceManager.class) {
				if (userService == null) {
					userService = new UserService();
				}
			}
		}
		
		return userService;
	}
}
