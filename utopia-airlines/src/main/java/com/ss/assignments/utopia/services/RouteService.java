package com.ss.assignments.utopia.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ss.assignments.utopia.models.Route;

public class RouteService {
	SessionFactory sessionFactory;
	
	public RouteService() {
		this.sessionFactory = SessionFactorySingletonWrapper.getInstance();
	}
	
	public List<Route> getRoutes() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Route> routes = session.createQuery("FROM Route", Route.class).list();
		session.getTransaction().commit();
		session.close();
		
		return routes;
	}
}
