package com.ss.assignments.utopia.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.ss.assignments.utopia.models.Airplane;
import com.ss.assignments.utopia.models.AirplaneType;
import com.ss.assignments.utopia.models.Airport;
import com.ss.assignments.utopia.models.Flight;
import com.ss.assignments.utopia.models.Route;
import com.ss.assignments.utopia.models.User;
import com.ss.assignments.utopia.services.SessionFactorySingletonWrapper;

public class UserDAO {
	private static UserDAO instance;
	private SessionFactory sessionFactory;
	
	protected UserDAO() {
		sessionFactory = SessionFactorySingletonWrapper.getInstance();
	}
	
	public static UserDAO getInstance() {
		if (instance == null) {
			synchronized(FlightDAO.class) {
				if (instance == null) {
					instance = new UserDAO();
				}
			}
		}
		
		return instance;
	}
	
	public List<User> getUsers() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<User> users = session.createQuery("FROM User", User.class).list();
		session.getTransaction().commit();
		session.close();
		
		return users;
	}
	
	public List<User> getUsersWithRole(int roleId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<User> preparedQuery = session.createQuery("SELECT u FROM User u WHERE u.role = :id", User.class);
		preparedQuery.setParameter("id", roleId);
		List<User> results = preparedQuery.list();
		session.getTransaction().commit();
		session.close();
		
		return results;
	}
	
	public void save(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(user);
			session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
	
	public void delete(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try {
			session.delete(user);
			session.getTransaction().commit();
		} catch(Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
}
