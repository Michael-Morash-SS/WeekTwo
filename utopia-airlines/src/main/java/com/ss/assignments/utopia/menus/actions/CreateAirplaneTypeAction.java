package com.ss.assignments.utopia.menus.actions;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ss.assignments.utopia.models.AirplaneType;
import com.ss.assignments.utopia.services.ServiceManager;

public class CreateAirplaneTypeAction implements FlowMenuAction {

	@Override
	public void executeAction() {
		// TODO Auto-generated method stub
		
	}
	
	public AirplaneType createAirplaneTypePrompt() {
		Scanner input = ServiceManager.getScanner();
		
		AirplaneType newAirplaneType = new AirplaneType();
		
		Integer maximumCapacity = null;
		
		System.out.println("Creating new airplane type");
		
		do {
			try {
				System.out.print("Maximum Capacity: ");
				maximumCapacity = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Error: Expecting a number");
				input.nextLine();
			}
		} while(maximumCapacity == null);
		
		newAirplaneType.setMaxCapacity(maximumCapacity);
		
		System.out.println("New airplane type created");
		
		return newAirplaneType;
	}
}
