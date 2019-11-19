package com.perscholas.project05;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/Exercise5Servlet", "/Exercise5Servlet/*"})
public class Exercise5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Exercise5Servlet() {
        super();
    }

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
				case "/Exercise5Servlet":
					showLogin(request, response);
					break;
				case "/Exercise5Servlet/Register":
					showRegister(request, response);
					break;
				case "/Exercise5Servlet/Welcome":
					showWelcome(request, response);
					break;
				case "/Exercise5Servlet/HomeForm":
					showHomeForm(request, response);
					break;
				case "/Exercise5Servlet/Quote":
					showQuote(request, response);
					break;
				case "/Exercise5Servlet/Thanks":
					showThanks(request, response);
					break;
				case "/Exercise5Servlet/Quotes":
					showQuotes(request, response);
					break;
				default:
					showLogin(request, response);
					break;
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	// POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("registerBtn") != null) {
			try {
				CustomerDAO cdao = new CustomerDAO();
				
				String firstName = request.getParameter("fName");
				String lastName = request.getParameter("lName");
				String dobString = request.getParameter("dob");
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				
				DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
				Date dob = format.parse(dobString);
				
				System.out.println(dob);
				
				cdao.createCustomer(new Customer(1, firstName, lastName, email, password, dob));
				doGet(request, response);
				
			} catch (ClassNotFoundException | SQLException | ParseException e) {
				e.printStackTrace();
			}
			
		}
		
		if(request.getParameter("loginBtn") != null) {
			try {
				CustomerDAO cdao = new CustomerDAO();
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
				Customer c = cdao.getCustomer(username);
				
				if(password.equals(c.getUserPassword())) {
					showWelcome(request, response);
				} else {
					request.setAttribute("error", "Invalid Login");
					showLogin(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(request.getParameter("getQuoteBtn") != null) {
			try {
				HttpSession sess = request.getSession();
				HomeDAO hdao = new HomeDAO();

				String addr1 = request.getParameter("addr1");
				String addr2 = request.getParameter("addr2");
				String city = request.getParameter("city");
				String state = request.getParameter("state");
				int zip = Integer.parseInt(request.getParameter("zip"));
				int yearBuilt = Integer.parseInt(request.getParameter("yearBuilt"));
				double value = Double.parseDouble(request.getParameter("value"));
				
				Home h = new Home(1, 1, addr1, addr2, city, state, zip, yearBuilt, value);
				sess.setAttribute("homeValue", h.getHomeValue()*.05);
				hdao.createHome(h);
				doGet(request, response);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	private void showLogin(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
	}
	
	private void showRegister(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/Registration.jsp").forward(request, response);
	}

	private void showWelcome(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp").forward(request, response);
	}
	
	private void showHomeForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/GetQuote.jsp").forward(request, response);
	}
	
	private void showQuote(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/Quote.jsp").forward(request, response);
	}
	
	private void showThanks(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/ThankYou.jsp").forward(request, response);
	}
	
	private void showQuotes(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/RetrieveQuotes.jsp").forward(request, response);
	}
}
