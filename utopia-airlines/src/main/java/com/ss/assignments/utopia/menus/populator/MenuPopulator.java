/**
 * 
 */
package com.ss.assignments.utopia.menus.populator;

import com.ss.assignments.utopia.menus.FlowMenu;
import com.ss.assignments.utopia.menus.FlowMenuOption;
import com.ss.assignments.utopia.menus.actions.FlowMenuAction;

/**
 * @author Michael
 *
 */
public interface MenuPopulator {
	public void populateMenu(FlowMenu menu, FlowMenu destinationMenu);
}
