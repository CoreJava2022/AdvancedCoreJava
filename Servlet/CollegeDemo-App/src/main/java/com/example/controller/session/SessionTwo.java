package com.example.controller.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionTwo extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter out = response.getWriter()) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title> Servlet Session Two</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1> Servlet SessionTwo at " + request.getContextPath() + "</h1>");
			Cookie[] cookies = request.getCookies();
			boolean f = false;
			String name = "";
			if (cookies == null) {
				out.println("<h1>You are new user, go to home page and submit your name!</h1>");
				return;
			} else {
				for (Cookie c : cookies) {
					String cookiesName = c.getName();

					if (cookiesName.equals("user_name")) {
						f = true;
						name = c.getValue();
					}
				}
			}
			if (f) {
				out.println("<h1> Hello " + name + ", " + "Welcome back!</h1>");
			} else {
				out.println("<h1>You are new user, go to home page and submit your name!</h1>");
			}

			out.println("<a href='session.html'>Home</a>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	public String getServletInfo() {
		return "Short Description";
	}
}
