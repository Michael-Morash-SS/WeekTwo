package com.ss.assignments.utopia.menus.actions;

import java.util.Scanner;

import com.ss.assignments.utopia.models.Airport;
import com.ss.assignments.utopia.services.AirportService;
import com.ss.assignments.utopia.services.ServiceManager;

public class CreateAirportAction implements FlowMenuAction {

	@Override
	public void executeAction() {
		AirportService airportService = ServiceManager.getAirportService();
		Airport newAirport = createAirportPrompt();
		airportService.save(newAirport);
	}
	
	public Airport createAirportPrompt() {
		Scanner input = ServiceManager.getScanner();
		
		Airport newAirport = new Airport();
		String iata = null;
		String city = null;
		
		System.out.println("Creating new airport");
		
		do {
			System.out.print("Enter the IATA: ");
			iata = input.next();
			
			if (iata.length() != 3) {
				iata = null;
				System.out.println("Error: IATA cannot exceed three letters");
			}
		} while(iata == null);
		
		//Clear input
		input.nextLine();
		
		System.out.print("Enter the city: ");
		city = input.nextLine();
		
		newAirport.setIata(iata);
		newAirport.setCity(city);
		
		System.out.println("New airport created");
		
		return newAirport;
	}
	
}
