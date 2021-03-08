package com.ss.assignments.utopia.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ss.assignments.utopia.models.Airplane;

public class AirplaneService {
	SessionFactory sessionFactory;
	
	public AirplaneService() {
		sessionFactory = SessionFactorySingletonWrapper.getInstance();
	}
	
	public List<Airplane> getAirplanes() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Airplane> airplanes = session.createQuery("FROM Airplane", Airplane.class).list();
		session.getTransaction().commit();
		session.close();
		
		return airplanes;
	}
}
