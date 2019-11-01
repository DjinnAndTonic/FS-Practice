package com.perscholas.servlets;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/loginform.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String dob = request.getParameter("dob");
		
		if(request.getParameter("loginbtn") != null) {
			String userName = request.getParameter("usernameIn");
			String userPassword = request.getParameter("passwordIn");
			if (userName.equals(username) && userPassword.equals(password)) {
				response.sendRedirect("welcome.jsp");
			}else {
				request.setAttribute("error", "Invalid Login");
//				response.sendRedirect("/WEB-INF/loginform.jsp");
				request.getRequestDispatcher("WEB-INF/loginform.jsp").forward(request, response);
			}
		}
		if(request.getParameter("registerbtn") != null) {
//			response.sendRedirect("/WEB-INF/register.jsp");
			request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
		}
		if(request.getParameter("completeRegister" )!= null) {
			Cookie c1 = new Cookie("dob", dob);
			Cookie c2 = new Cookie("username", username);
			Cookie c3 = new Cookie("password", password);
			
			c1.setMaxAge(60 * 5);
			c2.setMaxAge(60 * 5);
			c3.setMaxAge(60 * 5);
			response.addCookie(c1);
			response.addCookie(c2);
			response.addCookie(c3);
			
//			response.sendRedirect("/WEB-INF/loginform.jsp");
			request.getRequestDispatcher("/WEB-INF/loginform.jsp").forward(request, response);
		}
	}

}
