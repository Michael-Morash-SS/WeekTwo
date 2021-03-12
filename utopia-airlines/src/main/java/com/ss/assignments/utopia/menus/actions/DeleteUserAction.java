/**
 * 
 */
package com.ss.assignments.utopia.menus.actions;

import com.ss.assignments.utopia.menus.MenuSession;
import com.ss.assignments.utopia.models.User;
import com.ss.assignments.utopia.services.ServiceManager;
import com.ss.assignments.utopia.services.UserService;

/**
 * @author Michael
 *
 */
public class DeleteUserAction implements FlowMenuAction {

	@Override
	public void executeAction() {
		UserService userService = ServiceManager.getUserService();
		MenuSession session = MenuSession.getInstance();
		User user = session.getUser();
		
		userService.delete(user);
	}

}
