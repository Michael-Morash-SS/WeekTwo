/**
 * 
 */
package com.ss.assignments.utopia.menus.actions;

import com.ss.assignments.utopia.menus.FlowMenu;
import com.ss.assignments.utopia.menus.MenuSession;
import com.ss.assignments.utopia.models.User;

/**
 * @author Michael
 *
 */
public class SetSessionUserAndStartMenuAction implements FlowMenuAction {
	MenuSession session;
	FlowMenu menu;
	User user;
	
	public SetSessionUserAndStartMenuAction(FlowMenu menu, User user) {
		this.session = MenuSession.getInstance();
		this.menu = menu;
		this.user = user;
	}
	
	@Override
	public void executeAction() {
		session.setUser(user);
		
		menu.start();
	}
}
