/**
 * 
 */
package com.ss.assignments.utopia;

import java.util.List;
import java.util.Scanner;

import com.ss.assignments.utopia.menus.FlowMenu;
import com.ss.assignments.utopia.menus.FlowMenuOption;
import com.ss.assignments.utopia.menus.PaginatedFlowMenu;
import com.ss.assignments.utopia.menus.actions.CreateFlightAction;
import com.ss.assignments.utopia.menus.actions.DeleteFlightAction;
import com.ss.assignments.utopia.menus.actions.EditFlightAction;
import com.ss.assignments.utopia.menus.actions.StartMenuAction;
import com.ss.assignments.utopia.menus.actions.StartMenuWithPopulatorAction;
import com.ss.assignments.utopia.menus.actions.ViewFlightAction;
import com.ss.assignments.utopia.menus.populator.PopulateFlightList;
import com.ss.assignments.utopia.models.Airport;
import com.ss.assignments.utopia.services.AirportService;
import com.ss.assignments.utopia.services.FlightService;
import com.ss.assignments.utopia.services.ServiceManager;

/**
 * @author Michael
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Builds menus and starts the main menu
		Scanner input = ServiceManager.getScanner();
		
		//Instantiate menus
		FlowMenu mainMenu = new FlowMenu("Welcome to the Utopia Airlines Management System. Which category of a user are you?", input);
		
		FlowMenu employeeStartMenu = new FlowMenu("Employee: Select an action from below:", input);
		
		PaginatedFlowMenu employeeFlightIndexMenu = new PaginatedFlowMenu("Select a flight", input);
		
		FlowMenu employeeManageFlightMenu = new FlowMenu("Manage flight", input);
		
		FlowMenu administratorStartMenu = new FlowMenu("Administrator: Select an action from below:", input);
		
		FlowMenu administratorFlightMenu = new FlowMenu("Administrator-Flights: Select an action from below:", input);

		PaginatedFlowMenu administratorFlightListMenu = new PaginatedFlowMenu("Select flight:", input);
		
		FlowMenu administratorManageFlightMenu  = new FlowMenu("Select action for flight:", input);
		
		FlowMenu travelerStartMenu = new FlowMenu("Traveler: Select an action from below:", input);
		
		// Set up menu flow
		mainMenu.addOption(new FlowMenuOption("Employee", new StartMenuAction(employeeStartMenu)));
		mainMenu.addOption(new FlowMenuOption("Administrator", new StartMenuAction(administratorStartMenu)));
		mainMenu.addOption(new FlowMenuOption("Traveler", new StartMenuAction(travelerStartMenu)));

		employeeStartMenu.addOption(new FlowMenuOption("Select flight to manage",
				new StartMenuWithPopulatorAction(employeeFlightIndexMenu, employeeManageFlightMenu, new PopulateFlightList())
			));
		
		employeeManageFlightMenu.addOption(new FlowMenuOption("View more details about the flight", new ViewFlightAction()));
		employeeManageFlightMenu.addOption(new FlowMenuOption("Update flight details", new EditFlightAction()));

		administratorStartMenu.addOption(new FlowMenuOption("Flights", new StartMenuAction(administratorFlightMenu)));
		
		administratorFlightMenu.addOption(new FlowMenuOption("Create new flight", new CreateFlightAction()));
		administratorFlightMenu.addOption(new FlowMenuOption("Manage existing flight", 
				new StartMenuWithPopulatorAction(administratorFlightListMenu, administratorManageFlightMenu, new PopulateFlightList())
			));
		
		administratorManageFlightMenu.addOption(new FlowMenuOption("View flight", new ViewFlightAction()));
		administratorManageFlightMenu.addOption(new FlowMenuOption("Edit flight", new EditFlightAction()));
		administratorManageFlightMenu.addOption(new FlowMenuOption("Delete flight", new DeleteFlightAction()));
		
		// Start the main menu
		mainMenu.start();
	}

}
