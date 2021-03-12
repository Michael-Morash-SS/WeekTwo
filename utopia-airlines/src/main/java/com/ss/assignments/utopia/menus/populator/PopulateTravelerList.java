/**
 * 
 */
package com.ss.assignments.utopia.menus.populator;

import java.util.List;

import com.ss.assignments.utopia.menus.FlowMenu;
import com.ss.assignments.utopia.menus.FlowMenuOption;
import com.ss.assignments.utopia.menus.actions.SetSessionUserAndStartMenuAction;
import com.ss.assignments.utopia.models.User;
import com.ss.assignments.utopia.services.ServiceManager;
import com.ss.assignments.utopia.services.UserService;

/**
 * @author Michael
 *
 */
public class PopulateTravelerList implements MenuPopulator {

	@Override
	public void populateMenu(FlowMenu menu, FlowMenu destinationMenu) {
		menu.clearOptions();
		UserService userService = ServiceManager.getUserService();
		List<User> userList = userService.getTravelers();
		
		for (User u : userList) {
			menu.addOption(new FlowMenuOption(getUserString(u), new SetSessionUserAndStartMenuAction(destinationMenu, u)));
		}
	}
	
	public String getUserString(User user) {
		return user.getUsername() + " - " + user.getGivenName() + " " + user.getFamilyName();
	}

}
