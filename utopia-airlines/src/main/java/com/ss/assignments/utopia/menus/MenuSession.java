package com.ss.assignments.utopia.menus;

import com.ss.assignments.utopia.models.Airport;
import com.ss.assignments.utopia.models.Flight;
import com.ss.assignments.utopia.models.FlightSeat;
import com.ss.assignments.utopia.models.User;

public class MenuSession {
	private static MenuSession session;
	private Flight flight;
	private FlightSeat seat;
	private Airport airport;
	private User user;
	
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
	
	public FlightSeat getFlightSeat() {
		return seat;
	}
	
	public void setFlightSeat(FlightSeat seat) {
		this.seat = seat;
	}
	
	public Airport getAirport() {
		return airport;
	}
	
	public void setAirport(Airport airport) {
		this.airport = airport;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
