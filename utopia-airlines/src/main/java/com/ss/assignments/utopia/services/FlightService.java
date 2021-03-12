package com.ss.assignments.utopia.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.jpa.HibernateEntityManager;
import org.hibernate.query.Query;

import com.ss.assignments.utopia.dao.FlightDAO;
import com.ss.assignments.utopia.models.Airplane;
import com.ss.assignments.utopia.models.AirplaneType;
import com.ss.assignments.utopia.models.Airport;
import com.ss.assignments.utopia.models.Flight;
import com.ss.assignments.utopia.models.FlightSeat;
import com.ss.assignments.utopia.models.Route;

public class FlightService {
	private FlightDAO flightDAO;
	
	public FlightService() {
		this.flightDAO = FlightDAO.getInstance();
	}
	
	public List<Flight> getFlights() {
		return flightDAO.getFlights();
	}
	
	public Flight getFlightById(Integer id) {
		return flightDAO.getFlightById(id);
	}
	
	public void save(Flight flight) {
		flightDAO.save(flight);
	}
	
	public void delete(Flight flight) {
		flightDAO.delete(flight);
	}
	
	public List<FlightSeat> getSeats() {
		return flightDAO.getSeats();
	}
	
	public void saveSeat(FlightSeat flightSeat) {
		flightDAO.saveSeat(flightSeat);
	}

}
