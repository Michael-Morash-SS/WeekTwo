/**
 * 
 */
package com.ss.assignments.utopia.menus.actions;

import java.util.Scanner;

import com.ss.assignments.utopia.models.User;
import com.ss.assignments.utopia.services.InputService;
import com.ss.assignments.utopia.services.ServiceManager;
import com.ss.assignments.utopia.services.UserService;

/**
 * @author Michael
 *
 */
public class CreateEmployeeAction implements FlowMenuAction {

	@Override
	public void executeAction() {
		UserService userService = ServiceManager.getUserService();
		User newEmployee = createEmployeePrompt();
		userService.save(newEmployee);
	}

	public User createEmployeePrompt() {
		InputService inputService = InputService.getInstance();
		Scanner input = ServiceManager.getScanner();
		
		User newUser = new User();
		newUser.setRole(2);
		input.nextLine();
		newUser.setGivenName(inputService.getStringInput("Enter given name: "));
		newUser.setFamilyName(inputService.getStringInput("Enter family name: "));
		newUser.setUsername(inputService.getStringInput("Enter username: "));
		newUser.setPassword(inputService.getStringInput("Enter password: "));
		newUser.setEmail(inputService.getStringInput("Enter email:"));
		newUser.setPhone(inputService.getStringInput("Enter phone number:"));
		
		return newUser;
	}
}
