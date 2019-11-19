package com.perscholas.project02;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Exercise2Servlet
 */
@WebServlet({"/Exercise2Servlet", "/Exercise2Servlet/*"})
public class Exercise2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exercise2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = null;
		String servletPath = request.getServletPath();
		String pathInfo = request.getPathInfo();
		
		if (pathInfo == null || pathInfo.equals("/")) {
			action = servletPath;
		} else {
			action = servletPath + pathInfo;
		}
		
		System.out.println("ACTION: " + action);
		
		try {
			switch(action) {
				case "/Exercise2Servlet":
					showForm(request, response);
					break;
				case "/Exercise2Servlet/Profile":
					showProfile(request, response);
					break;
				case "/Exercise2Servlet/Home":
					showHome(request, response);
					break;
				case "/Exercise2Servlet/Update":
					showUpdate(request, response);
					break;
				default:
					showForm(request, response);
					break;
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
//		request.getRequestDispatcher("/WEB-INF/views/ExerciseTwoForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("submitUpdate") != null) {
			try {
				UserDAO udao = new UserDAO();
				String newUsername = request.getParameter("newUsername");
				String newPassword = request.getParameter("newPassword");
				String updateUserId = request.getParameter("currentUserId");
				
				User updatedUser = new User(Integer.parseInt(updateUserId), newUsername, newPassword);
								
				udao.updateUser(updatedUser);
				
				HttpSession session = request.getSession();
				session.setAttribute("currentUser", udao.findUserByName(newUsername));
				
				udao.closeResources();
			
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			doGet(request, response);
			return;
		}
		
		if(request.getParameter("submitForm") != null) {			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			System.out.println(username + "\n" + password);
			
			try {
				UserDAO udao = new UserDAO();
				User u = new User();
				
				u = udao.findUserByName(username);
				if(u != null) {
					if(u.getUsername().equals(username)) {
						HttpSession session = request.getSession();
						session.setAttribute("currentUser", u);
						request.getRequestDispatcher("/WEB-INF/views/Index.jsp").forward(request, response);
					} else {
						request.setAttribute("error", "Invalid Login");
					}
				}
				
				udao.closeResources();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			doGet(request, response);
		}
	}
	
	private void showForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/ExerciseTwoForm.jsp").forward(request, response);
	}
	
	private void showProfile(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/UserProfile.jsp").forward(request, response);
	}
	
	private void showUpdate(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/UpdateUser.jsp").forward(request, response);
	}
	
	private void showHome(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/Index.jsp").forward(request, response);
	}

}
