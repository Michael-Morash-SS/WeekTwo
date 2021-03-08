package com.ss.assignments.utopia.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.jpa.HibernateEntityManager;
import org.hibernate.query.Query;

import com.ss.assignments.utopia.models.Airplane;
import com.ss.assignments.utopia.models.AirplaneType;
import com.ss.assignments.utopia.models.Airport;
import com.ss.assignments.utopia.models.Flight;
import com.ss.assignments.utopia.models.Route;

public class FlightService {
	SessionFactory sessionFactory;
	
	public FlightService() {
		this.sessionFactory = SessionFactorySingletonWrapper.getInstance();
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
		}
		session.close();
	}
	
	public void delete(Flight flight) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.delete(flight);
		
		session.getTransaction().commit();
		session.close();
	}

}
