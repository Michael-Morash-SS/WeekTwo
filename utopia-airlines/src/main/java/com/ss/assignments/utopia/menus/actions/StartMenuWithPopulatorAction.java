package com.ss.assignments.utopia.menus.actions;

import com.ss.assignments.utopia.menus.FlowMenu;
import com.ss.assignments.utopia.menus.populator.MenuPopulator;

public class StartMenuWithPopulatorAction implements FlowMenuAction {
	FlowMenu menu;
	FlowMenu destination;
	MenuPopulator populator;
	
	public StartMenuWithPopulatorAction(FlowMenu menu, FlowMenu destination, MenuPopulator populator) {
		this.menu = menu;
		this.populator = populator;
		this.destination = destination;
	}

	@Override
	public void executeAction() {
		menu.clearOptions();
		populator.populateMenu(menu, destination);
		menu.start();
	}
	
	
}
