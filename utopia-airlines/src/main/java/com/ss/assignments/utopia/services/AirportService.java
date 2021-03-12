/**
 * 
 */
package com.ss.assignments.utopia.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ss.assignments.utopia.models.Airport;

/**
 * @author Michael
 *
 */
public class AirportService {
	SessionFactory sessionFactory;
	
	public AirportService() {
		this.sessionFactory = SessionFactorySingletonWrapper.getInstance();
	}
	
	public List<Airport> getAirports() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Airport> results = session.createQuery("from Airport").list();
		session.getTransaction().commit();
		session.close();
		
		return results;
	}
	
	public void save(Airport airport) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		try {
			session.saveOrUpdate(airport);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
	
	public void delete(Airport airport) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try {
			session.delete(airport);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
}
