package com.ss.assignments.utopia.menus;

import com.ss.assignments.utopia.models.Flight;

public class MenuSession {
	private static MenuSession session;
	private Flight flight;
	
	private MenuSession() {};
	
	public static MenuSession getInstance() {
		if (session == null) {
			synchronized(MenuSession.class) {
				if (session == null) {
					session = new MenuSession();
				}
			}
		}
		
		return session;
	}
	
	public Flight getFlight() {
		return flight;
	}
	
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
}
