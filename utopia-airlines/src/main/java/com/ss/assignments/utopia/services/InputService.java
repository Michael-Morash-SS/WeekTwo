package com.ss.assignments.utopia.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputService {
	private static volatile InputService instance;
	private Scanner input;
	
	private InputService() {
		this.input = ServiceManager.getScanner();
	}
	
	public static InputService getInstance() {
		if (instance == null) {
			synchronized(InputService.class) {
				if (instance == null) {
					instance = new InputService();
				}
			}
		}
		
		return instance;
	}
	
	public int getIntInput(String prompt, String errorMessage) {
		int userInput = 0;
		boolean success = false;
		
		do {
			try {
				System.out.print(prompt);
				userInput = input.nextInt();
				success = true;
			} catch (InputMismatchException e) {
				System.out.println(errorMessage);
				input.nextLine();
				continue;
			}
		} while (!success);
		
		return userInput;
	}
	
	public int getIntInput(String prompt) {
		return getIntInput(prompt, "Error: Expecting integer input");
	}
	
	public float getFloatInput(String prompt, String errorMessage) {
		float userInput = 0;
		boolean success = false;
		
		do {
			try {
				System.out.print(prompt);
				userInput = input.nextFloat();
				success = true;
			} catch (InputMismatchException e) {
				System.out.println(errorMessage);
				input.nextLine();
				continue;
			}
		} while (!success);
		
		return userInput;
	}
	
	public float getFloatInput(String prompt) {
		return getFloatInput(prompt, "Error: Expecting float input");
	}
	
	public String getStringInput(String prompt) {
		System.out.print(prompt);
		return input.nextLine();
	}
	
	public LocalDateTime getDateTimeInput(String prompt) {
		LocalDateTime userInput = null;
		boolean success = false;
		int month = 0, day = 0, year = 0, hour = 0, minute = 0;

		year = getIntInput(prompt + "(Year) ");
		
		do {
			month = getIntInput(prompt + "(Month) ");
		} while(month < 1 || 12 < month);
		
		boolean isLeapYear = LocalDate.of(year, month, 1).isLeapYear();
		
		do {
			day = getIntInput(prompt + "(Day) ");
		} while(day < 1 || Month.of(month).length(isLeapYear) < day);
		
		do {
			hour = getIntInput(prompt + "(Hour) ");
		} while(hour < 0 || 23 < hour);
		
		do {
			minute = getIntInput(prompt + "(Minute) ");
		} while (minute < 0 || 59 < minute);
		
		userInput = LocalDateTime.of(year, month, day, hour, minute);
		
		return userInput;
	}
}
