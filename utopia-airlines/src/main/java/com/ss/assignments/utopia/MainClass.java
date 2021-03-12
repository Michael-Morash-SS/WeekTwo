/**
 * 
 */
package com.ss.assignments.utopia;

import java.util.List;
import java.util.Scanner;

import com.ss.assignments.utopia.menus.FlowMenu;
import com.ss.assignments.utopia.menus.FlowMenuOption;
import com.ss.assignments.utopia.menus.PaginatedFlowMenu;
import com.ss.assignments.utopia.menus.actions.CreateAirportAction;
import com.ss.assignments.utopia.menus.actions.CreateEmployeeAction;
import com.ss.assignments.utopia.menus.actions.CreateFlightAction;
import com.ss.assignments.utopia.menus.actions.CreateSeatAction;
import com.ss.assignments.utopia.menus.actions.CreateTravelerAction;
import com.ss.assignments.utopia.menus.actions.DeleteAirportAction;
import com.ss.assignments.utopia.menus.actions.DeleteFlightAction;
import com.ss.assignments.utopia.menus.actions.DeleteUserAction;
import com.ss.assignments.utopia.menus.actions.EditAirportAction;
import com.ss.assignments.utopia.menus.actions.EditFlightAction;
import com.ss.assignments.utopia.menus.actions.EditUserAction;
import com.ss.assignments.utopia.menus.actions.StartMenuAction;
import com.ss.assignments.utopia.menus.actions.StartMenuWithPopulatorAction;
import com.ss.assignments.utopia.menus.actions.ViewAirportAction;
import com.ss.assignments.utopia.menus.actions.ViewFlightAction;
import com.ss.assignments.utopia.menus.actions.ViewUserAction;
import com.ss.assignments.utopia.menus.populator.PopulateAirportList;
import com.ss.assignments.utopia.menus.populator.PopulateEmployeeList;
import com.ss.assignments.utopia.menus.populator.PopulateFlightList;
import com.ss.assignments.utopia.menus.populator.PopulateSeatList;
import com.ss.assignments.utopia.menus.populator.PopulateTravelerList;
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
		
		FlowMenu administratorSeatMenu = new FlowMenu("Administrator-Seats: Select an action from below:", input);
		
		PaginatedFlowMenu administratorSeatListMenu = new PaginatedFlowMenu("Select seats:", input);
		
		FlowMenu administratorManageSeatMenu = new FlowMenu("Select action for seat:", input);
		
		FlowMenu administratorAirportMenu = new FlowMenu("Administrator-Airports: Select an action from below:", input);
		
		PaginatedFlowMenu administratorAirportListMenu = new PaginatedFlowMenu("Select airport:", input);
		
		FlowMenu administratorManageAirportMenu = new FlowMenu("Select action for airport:", input);
		
		FlowMenu administratorTravelerMenu = new FlowMenu("Administrator-Travelers: Select an action from below:", input);
		
		PaginatedFlowMenu administratorTravelerListMenu = new PaginatedFlowMenu("Select traveler:", input);
		
		FlowMenu administratorManageTravelerMenu = new FlowMenu("Select action for traveler:", input);
		
		FlowMenu administratorEmployeeMenu = new FlowMenu("Administrator-Employees: Select an action from below:", input);
		
		PaginatedFlowMenu administratorEmployeeListMenu = new PaginatedFlowMenu("Select employee:", input);
		
		FlowMenu administratorManageEmployeeMenu = new FlowMenu("Select action for employee:", input);
		
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
		administratorStartMenu.addOption(new FlowMenuOption("Seats", new StartMenuAction(administratorSeatMenu)));
		administratorStartMenu.addOption(new FlowMenuOption("Airports", new StartMenuAction(administratorAirportMenu)));
		administratorStartMenu.addOption(new FlowMenuOption("Travelers", new StartMenuAction(administratorTravelerMenu)));
		administratorStartMenu.addOption(new FlowMenuOption("Employees", new StartMenuAction(administratorEmployeeMenu)));
		
		administratorFlightMenu.addOption(new FlowMenuOption("Create new flight", new CreateFlightAction()));
		administratorFlightMenu.addOption(new FlowMenuOption("Manage existing flight", 
				new StartMenuWithPopulatorAction(administratorFlightListMenu, administratorManageFlightMenu, new PopulateFlightList())
			));
		
		administratorManageFlightMenu.addOption(new FlowMenuOption("View flight", new ViewFlightAction()));
		administratorManageFlightMenu.addOption(new FlowMenuOption("Edit flight", new EditFlightAction()));
		administratorManageFlightMenu.addOption(new FlowMenuOption("Delete flight", new DeleteFlightAction()));
		
		administratorSeatMenu.addOption(new FlowMenuOption("Create new seat", new CreateSeatAction()));
		administratorSeatMenu.addOption(new FlowMenuOption("Manage existing seat",
				new StartMenuWithPopulatorAction(administratorSeatListMenu, administratorManageSeatMenu, new PopulateSeatList())
			));
		
		administratorAirportMenu.addOption(new FlowMenuOption("Create new airport", new CreateAirportAction()));
		administratorAirportMenu.addOption(new FlowMenuOption("Manage existing airport",
				new StartMenuWithPopulatorAction(administratorAirportListMenu, administratorManageAirportMenu, new PopulateAirportList())
			));
		
		administratorManageAirportMenu.addOption(new FlowMenuOption("View airport", new ViewAirportAction()));
		administratorManageAirportMenu.addOption(new FlowMenuOption("Edit airport", new EditAirportAction()));
		administratorManageAirportMenu.addOption(new FlowMenuOption("Delete airport", new DeleteAirportAction()));
		
		administratorTravelerMenu.addOption(new FlowMenuOption("Create new traveler", new CreateTravelerAction()));
		administratorTravelerMenu.addOption(new FlowMenuOption("Manage existing traveler",
				new StartMenuWithPopulatorAction(administratorTravelerListMenu, administratorManageTravelerMenu, new PopulateTravelerList())
			));
		
		administratorManageTravelerMenu.addOption(new FlowMenuOption("View traveler", new ViewUserAction()));
		administratorManageTravelerMenu.addOption(new FlowMenuOption("Edit traveler", new EditUserAction()));
		administratorManageTravelerMenu.addOption(new FlowMenuOption("Delete traveler", new DeleteUserAction()));
		
		administratorEmployeeMenu.addOption(new FlowMenuOption("Create new employee", new CreateEmployeeAction()));
		administratorEmployeeMenu.addOption(new FlowMenuOption("Manage existing employee",
				new StartMenuWithPopulatorAction(administratorEmployeeListMenu, administratorManageEmployeeMenu, new PopulateEmployeeList())
			));
		
		administratorManageEmployeeMenu.addOption(new FlowMenuOption("View employee", new ViewUserAction()));
		administratorManageEmployeeMenu.addOption(new FlowMenuOption("Edit employee", new EditUserAction()));
		administratorManageEmployeeMenu.addOption(new FlowMenuOption("Delete employee", new DeleteUserAction()));
		
		// Start the main menu
		mainMenu.start();
	}

}
