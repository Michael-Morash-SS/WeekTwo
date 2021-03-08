/**
 * 
 */
package com.ss.assignments.utopia.menus;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Michael
 *
 * Helps manage application flow by providing multiple options and handling input for flow
 *
 */
public class FlowMenu {
	private static final int INVALID_INDEX = -1;
	
	private String prompt;
	private String quitText = "Quit";
	private Scanner input;
	private boolean isFinished;
	
	private ArrayList<FlowMenuOption> options;
	
	
	
	public FlowMenu(String prompt, Scanner input) {
		this.prompt = prompt;
		this.input = input;
		options = new ArrayList<FlowMenuOption>();
	}
	
	// Option management
	
	public ArrayList<FlowMenuOption> getOptions() {
		return options;
	}
	
	public void setOptions(ArrayList<FlowMenuOption> options) {
		this.options = options;
	}
	
	public void addOption(FlowMenuOption option) {
		options.add(option);
	}
	
	public void clearOptions() {
		options = new ArrayList<FlowMenuOption>();
	}
	
	// Prompt management
	
	public String getPrompt() {
		return prompt;
	}
	
	// Finish management
	public void finish() {
		isFinished = true;
	}
	
	// get option count
	
	public int getOptionCount() {
		// Override for custom option count
		return options.size() + 1;
	}
	
	// Print options
	
	public void printOptions() {
		System.out.println(prompt);
		
		for (int i = 1; i <= getOptionCount(); i++) {
			System.out.println(getOptionString(i));
		}
	}
	
	public String getOptionString(int optionNumber) {
		//Override for custom option printing
		if (optionNumber <= options.size()) {
			return optionNumber + ") " + options.get(optionNumber - 1).getText();
		} else {
			return optionNumber + ") " + quitText;
		}
	}
	
	// Get users option selection
	
	public int getOptionSelection() {
		int optionSelected = INVALID_INDEX;
		
		do {
			System.out.print("Input: ");
			try {
				optionSelected = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Error: Expecting input from given options");
				input.nextLine();
				continue;
			}
			
			if (optionSelected < 0 || optionSelected > getOptionCount()) {
				System.out.println("Error: Expecting input from given options");
				optionSelected = INVALID_INDEX;
			}
		} while (optionSelected == INVALID_INDEX);
		
		return optionSelected;
	}
	
	public void runOption(int optionNumber) {
		//Override for custom implementation
		
		if (optionNumber <=  options.size()) {
			options.get(optionNumber - 1).executeAction();
		} else {
			finish();
		}
	}
	
	public void start() {
		int menuInput = 0;
		isFinished = false;
		
		do {
			printOptions();
			menuInput = getOptionSelection();
			runOption(menuInput);
		} while (!isFinished);
	}
}
