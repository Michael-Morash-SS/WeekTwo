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
	private int page_start = 0;
	private int page_length = 10;
	
	public PaginatedFlowMenu(String prompt, Scanner input) {
		super(prompt, input);
	}
	
	public void prevPage() {
		page_start -= page_length;
		
		if (page_start < 0) {
			page_start = 0;
		}
	}
	
	public void nextPage() {
		List<FlowMenuOption> options = getOptions();
		
		if (page_start + page_length < getOptions().size()) {
			page_start += page_length;
		}
	}
	
	public int getValidPageLength() {
		if (getOptions().size() < page_length) {
			return getOptions().size();
		}
		
		return page_length;
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
			return optionNumber + ") " + options.get(page_start + optionNumber - 1).getText();
		} else if (optionNumber == validPageLength + 1) {
			return optionNumber + ") Prev";
		} else if (optionNumber == validPageLength + 2) {
			return optionNumber + ") Next";
		} else if (optionNumber == validPageLength + 3) {
			return optionNumber + ") Quit";
		}
		
		return null;
	}
	
	@Override
	public void runOption(int optionNumber) {
		ArrayList<FlowMenuOption> options = getOptions();
		int validPageLength = getValidPageLength();
		
		if (optionNumber <= validPageLength) {
			options.get(page_start + optionNumber - 1).executeAction();
		} else if (optionNumber == validPageLength + 1) {
			prevPage();
		} else if (optionNumber == validPageLength + 2) {
			nextPage();
		} else if (optionNumber == validPageLength + 3) {
			finish();
		}
	}
}
