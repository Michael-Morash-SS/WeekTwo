package com.ss.assignments.utopia.menus;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PaginatedSelectionMenu<T> {
	private final int INVALID_INDEX = -1;
	
	private int page_start = 0;
	private int page_length = 10;
	
	private String prompt;
	private Scanner input;
	
	private List<T> options;
	
	public PaginatedSelectionMenu(String prompt, Scanner input, List<T> options) {
		this.prompt = prompt;
		this.input = input;
		this.options = options;
	}
	
	public void nextPage() {
		page_start += page_length;
		
		if (page_start >= options.size()) {
			page_start = options.size() - page_length;
			
			if (page_start < 0) {
				page_start = 0;
			}
		}
	}
	
	public void prevPage() {
		page_start -= page_length;
		
		if (page_start < 0) {
			page_start = 0;
		}
	}
	
	public int printOptions() {
		int i = 0;
		
		for (i = 0; i < page_length && page_start + i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i).toString());
		}
		
		System.out.println((i++ + 1) + ") Prev");
		System.out.println((i++ + 1) + ") Next");
		System.out.println((i++ + 1) + ") Quit");
		
		return i;
	}
	
	public T start() {
		int selectionIndex = INVALID_INDEX;
		int expectedMax;
		
		do  {
			expectedMax = printOptions();
			
			try {
				selectionIndex = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Error: Expecting input from given options");
				input.nextLine();
				continue;
			}
			
			if (selectionIndex <= 0 || selectionIndex > expectedMax) {
				System.out.println("Error: Expecting input from given options");
				selectionIndex = INVALID_INDEX;
				continue;
			}
			
			if (selectionIndex == expectedMax) {
				//Quit option
				return null;
			} else if (selectionIndex == expectedMax - 1) {
				//Next page option
				nextPage();
				selectionIndex = INVALID_INDEX;
				continue;
			} else if (selectionIndex == expectedMax - 2) {
				//Prev page option
				prevPage();
				selectionIndex = INVALID_INDEX;
				continue;
			}
			
			if (selectionIndex != INVALID_INDEX) {
				return options.get(page_start + selectionIndex - 1);
			}
		} while (selectionIndex == INVALID_INDEX);
		
		return null;
	}
}
