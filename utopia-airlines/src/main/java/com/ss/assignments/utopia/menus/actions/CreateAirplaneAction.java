/**
 * 
 */
package com.ss.assignments.utopia.menus.actions;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ss.assignments.utopia.menus.PaginatedSelectionMenu;
import com.ss.assignments.utopia.models.Airplane;
import com.ss.assignments.utopia.models.AirplaneType;
import com.ss.assignments.utopia.services.AirplaneTypeService;
import com.ss.assignments.utopia.services.ServiceManager;

/**
 * @author Michael
 *
 */
public class CreateAirplaneAction implements FlowMenuAction {

	@Override
	public void executeAction() {
		// TODO Auto-generated method stub

	}

	public Airplane createAirplanePrompt() {
		Scanner input = ServiceManager.getScanner();
		AirplaneTypeService airplaneTypeService = ServiceManager.getAirplaneTypeService();
		
		int flowInput;
		
		List<AirplaneType> airplaneTypeList = airplaneTypeService.getAirplaneTypes();
	
		PaginatedSelectionMenu<AirplaneType> selectAirplaneType = new PaginatedSelectionMenu<>("Select Airplane Type:", input, airplaneTypeList);
		
		CreateAirplaneTypeAction createAirplaneTypePrompt = new CreateAirplaneTypeAction();
		
		Airplane newAirplane = new Airplane();
		AirplaneType airplaneType = null;
		
		System.out.println("Creating new airplane");
		
		do {
			System.out.println("Select airplane type");
			System.out.println("1) Create new");
			System.out.println("2) Select existing");
			
			try {
				flowInput = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Error: Expecting input from given options");
				input.nextLine();
				continue;
			}
			
			if (flowInput == 1) {
				airplaneType = createAirplaneTypePrompt.createAirplaneTypePrompt();
			} else if (flowInput == 2) {
				airplaneType = selectAirplaneType.start();
			}
		} while (airplaneType == null);
		
		newAirplane.setAirplaneType(airplaneType);
		
		System.out.println("New airplane created");
		
		return newAirplane;
	}
}
