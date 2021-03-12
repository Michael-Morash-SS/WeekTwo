/**
 * 
 */
package com.ss.assignments.utopia.menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Michael
 *
 */
public class PaginatedFlowMenu extends FlowMenu {
	private int pageStart = 0;
	private int pageLength = 10;
	
	public PaginatedFlowMenu(String prompt, Scanner input) {
		super(prompt, input);
	}
	
	public int getPageStart() {
		return pageStart;
	}
	
	public void prevPage() {
		pageStart -= pageLength;
		
		if (pageStart < 0) {
			pageStart = 0;
		}
	}
	
	public void nextPage() {
		List<FlowMenuOption> options = getOptions();
		
		if (pageStart + pageLength < options.size()) {
			pageStart += pageLength;
		}
	}
	
	public int getValidPageLength() {
		if (getOptions().size() < pageStart + pageLength) {
			return getOptions().size() - pageStart;
		}
		
		return pageLength;
	}
	
	@Override
	public int getOptionCount() {
		return getValidPageLength() + 3;
	}
	
	@Override
	public String getOptionString(int optionNumber) {
		ArrayList<FlowMenuOption> options = getOptions();
		int validPageLength = getValidPageLength();
		
		if (optionNumber <= validPageLength) {
			return optionNumber + ") " + options.get(pageStart + optionNumber - 1).getText();
		} else if (optionNumber == validPageLength + 1) {
			return optionNumber + ") Prev";
		} else if (optionNumber == validPageLength + 2) {
			return optionNumber + ") Next";
		} else {
			return optionNumber + ") Quit";
		}
	}
	
	@Override
	public void runOption(int optionNumber) {
		ArrayList<FlowMenuOption> options = getOptions();
		int validPageLength = getValidPageLength();
		
		if (optionNumber <= validPageLength) {
			options.get(pageStart + optionNumber - 1).executeAction();
		} else if (optionNumber == validPageLength + 1) {
			prevPage();
		} else if (optionNumber == validPageLength + 2) {
			nextPage();
		} else if (optionNumber == validPageLength + 3) {
			finish();
		}
	}
}
