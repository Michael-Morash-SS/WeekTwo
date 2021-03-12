package com.ss.assignments.utopia.menus.actions;

import com.ss.assignments.utopia.menus.MenuSession;
import com.ss.assignments.utopia.models.User;

public class ViewUserAction implements FlowMenuAction {

	@Override
	public void executeAction() {
		MenuSession session = MenuSession.getInstance();
		User user = session.getUser();
		
		if (user.getRole() == 1) {
			System.out.println("Traveler User");
		} else if (user.getRole() == 2) {
			System.out.println("Employee User");
		}
		
		System.out.println("Given Name: " + user.getGivenName());
		System.out.println("Family Name: " + user.getFamilyName());
		System.out.println("Username: " + user.getUsername());
		System.out.println("Email: " + user.getEmail());
		System.out.println("Phone: " + user.getPhone());
	}

}
