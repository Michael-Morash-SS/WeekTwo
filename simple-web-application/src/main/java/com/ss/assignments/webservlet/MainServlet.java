/**
 * 
 */
package com.ss.assignments.webservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Michael
 *
 */

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 4931754360970548214L;
	
	public final String user = "user";
	public final String password = "password";
	
	public void init() {
		System.out.println("MainServlet Init");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter output = response.getWriter();
		output.println("<p>Login Info: user='" + user + "' password='" + password + "'</p>");
		output.println("<form method='POST'>");
		output.println("User:<input name=\"user\"/><br/>");
		output.println("Password:<input name=\"password\"/>");
		output.println("<button type='submit'>Submit</button>");
		output.println("</form>");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String attemptedUser = request.getParameter("user");
		String attemptedPassword = request.getParameter("password");
		
		if (user.equals(attemptedUser) && password.equals(attemptedPassword)) {
			response.getWriter().append("Login success");
		} else {
			response.getWriter().append("Login failed");
		}
	}
}
