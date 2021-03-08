/**
 * 
 */
package com.ss.assignments.utopia.menus.actions;

import com.ss.assignments.utopia.menus.FlowMenu;

/**
 * @author Michael
 *
 */
public class StartMenuAction implements FlowMenuAction {
	FlowMenu menu;
	
	public StartMenuAction(FlowMenu menu) {
		this.menu = menu;
	}

	@Override
	public void executeAction() {
		// TODO Auto-generated method stub
		menu.start();
	}

}
