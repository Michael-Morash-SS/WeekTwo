/**
 * 
 */
package com.ss.assignments.utopia.services;

import java.util.List;

import com.ss.assignments.utopia.dao.UserDAO;
import com.ss.assignments.utopia.models.User;

/**
 * @author Michael
 *
 */
public class UserService {
	UserDAO userDAO;
	
	public UserService() {
		userDAO = UserDAO.getInstance();
	}
	
	public List<User> getUsers() {
		return userDAO.getUsers();
	}
	
	public List<User> getTravelers() {
		return userDAO.getUsersWithRole(1);
	}
	
	public List<User> getTravelAgents() {
		return userDAO.getUsersWithRole(3);
	}
	
	public List<User> getEmployees() {
		return userDAO.getUsersWithRole(2);
	}
	
	public void save(User user) {
		userDAO.save(user);
	}
	
	public void delete(User user) {
		userDAO.delete(user);
	}
}
