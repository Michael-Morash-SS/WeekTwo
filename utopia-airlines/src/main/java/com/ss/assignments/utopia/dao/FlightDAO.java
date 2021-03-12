/**
 * 
 */
package com.ss.assignments.utopia.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.ss.assignments.utopia.models.Airplane;
import com.ss.assignments.utopia.models.AirplaneType;
import com.ss.assignments.utopia.models.Airport;
import com.ss.assignments.utopia.models.Flight;
import com.ss.assignments.utopia.models.FlightSeat;
import com.ss.assignments.utopia.models.Route;
import com.ss.assignments.utopia.services.SessionFactorySingletonWrapper;

/**
 * @author Michael
 *
 */
public class FlightDAO {
	private static FlightDAO instance;
	private SessionFactory sessionFactory;
	
	protected FlightDAO() {
		sessionFactory = SessionFactorySingletonWrapper.getInstance();
	}
	
	public static FlightDAO getInstance() {
		if (instance == null) {
			synchronized(FlightDAO.class) {
				if (instance == null) {
					instance = new FlightDAO();
				}
			}
		}
		
		return instance;
	}
	
	public List<Flight> getFlights() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Flight> flights = session.createQuery("FROM Flight", Flight.class).list();
		session.getTransaction().commit();
		session.close();
		
		return flights;
	}
	
	public Flight getFlightById(Integer id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Flight> query = session.createQuery("SELECT * FROM Flight f WHERE f.id = :id", Flight.class);
		query.setParameter("id", id);
		Flight flight = query.getSingleResult();
		session.getTransaction().commit();
		session.close();
		
		return flight;
	}
	
	public void save(Flight flight) {
		Route route = flight.getRoute();
		Airport origin = route.getOrigin();
		Airport destination = route.getDestination();
		
		Airplane airplane = flight.getAirplane();
		AirplaneType airplaneType = airplane.getAirplaneType();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(airplaneType);
			session.saveOrUpdate(airplane);
			session.saveOrUpdate(destination);
			session.saveOrUpdate(origin);
			session.saveOrUpdate(route);
			session.saveOrUpdate(flight);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
	
	public void saveSeat(FlightSeat flightSeat) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try {
			session.saveOrUpdate(flightSeat);
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void delete(Flight flight) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.delete(flight);
		
		session.getTransaction().commit();
		session.close();
	}

	public List<FlightSeat> getSeats() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<FlightSeat> seats = session.createQuery("FROM FlightSeat", FlightSeat.class).list();
		session.getTransaction().commit();
		session.close();
		
		return seats;
	}
}
