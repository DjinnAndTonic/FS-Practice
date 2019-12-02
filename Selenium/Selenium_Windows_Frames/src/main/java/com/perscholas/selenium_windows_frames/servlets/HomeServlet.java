package com.perscholas.selenium_windows_frames.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/HomeServlet", "/HomeServlet/*"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String action;
		if (request.getPathInfo() != null) {
			action = request.getServletPath() + request.getPathInfo();
		} else {
			action = request.getServletPath();
		}
		try
		{
			switch(action) {
			case "/HomeServlet":
				rd = request.getRequestDispatcher("/WEB-INF/views/SeleniumWindows.jsp");
				rd.forward(request, response);
				break;
			case "/HomeServlet/popUp":
				rd = request.getRequestDispatcher("/WEB-INF/views/SeleniumPopup.jsp");
				rd.forward(request, response);
				break;
			case "/HomeServlet/frames":
				rd = request.getRequestDispatcher("/WEB-INF/views/SeleniumFrames.jsp");
				rd.forward(request, response);
				break;
			case "/HomeServlet/frameOne":
				rd = request.getRequestDispatcher("/WEB-INF/views/Frame1.jsp");
				rd.forward(request, response);
				break;
			case "/HomeServlet/frameTwo":
				rd = request.getRequestDispatcher("/WEB-INF/views/Frame2.jsp");
				rd.forward(request, response);
				break;
			case "/HomeServlet/frameThree":
				rd = request.getRequestDispatcher("/WEB-INF/views/Frame3.jsp");
				rd.forward(request, response);
				break;
			default:
				rd = request.getRequestDispatcher("/WEB-INF/views/SeleniumWindows.jsp");
				rd.forward(request, response);
				break;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}