/**
 * 
 */
package com.ss.assignments.utopia.menus.actions;


import java.util.Scanner;

import com.ss.assignments.utopia.menus.MenuSession;
import com.ss.assignments.utopia.models.User;
import com.ss.assignments.utopia.services.InputService;
import com.ss.assignments.utopia.services.ServiceManager;
import com.ss.assignments.utopia.services.UserService;

/**
 * @author Michael
 *
 */
public class EditUserAction implements FlowMenuAction {

	@Override
	public void executeAction() {
		MenuSession session = MenuSession.getInstance();
		Scanner input = ServiceManager.getScanner();
		InputService inputService = InputService.getInstance();
		UserService userService = ServiceManager.getUserService();
		User user = session.getUser();
		
		user.setGivenName(inputService.getStringInput("Given name: "));
		user.setFamilyName(inputService.getStringInput("Family name: "));
		user.setUsername(inputService.getStringInput("Username: "));
		user.setPassword(inputService.getStringInput("Password: "));
		user.setEmail(inputService.getStringInput("Email: "));
		user.setPhone(inputService.getStringInput("Phone: "));
		
		userService.save(user);
	}

}
