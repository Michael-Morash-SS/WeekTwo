package com.ss.assignments.utopia.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ss.assignments.utopia.models.AirplaneType;

public class AirplaneTypeService {
	SessionFactory sessionFactory;
	
	public AirplaneTypeService() {
		sessionFactory = SessionFactorySingletonWrapper.getInstance();
	}
	
	public List<AirplaneType> getAirplaneTypes() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<AirplaneType> airplaneTypes = session.createQuery("FROM AirplaneType", AirplaneType.class).list();
		session.getTransaction().commit();
		session.close();
		
		return airplaneTypes;
	}
}
