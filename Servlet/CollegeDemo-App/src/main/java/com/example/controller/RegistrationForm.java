package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationForm extends HttpServlet {
	
	public void doGet(HttpServletRequest request , HttpServletResponse response)throws IOException,ServletException {
		
		response.setContentType("text/html");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		
		PrintWriter pw = response.getWriter();
	     
		String college_Name = getServletContext().getInitParameter("College_Name");
		pw.print("<h1 style=\"color:green;\">"+college_Name +"</h1><br/>");
		
		pw.println("<h3 style =\" color: blue \">"+name+"</h3><br/>");
		pw.println("<h3 style =\" color: orange \">"+email+"</h3>");
		ServletConfig servletConfig = getServletConfig();
		String personalEmail1 =servletConfig.getInitParameter("personalEmail");
		pw.println("<h3 style =\" color: red \"> Personal Email:"+personalEmail1+"</h3>");
		String website = getServletContext().getInitParameter("Application_Name");
		pw.println("<h3 style =\" color: skyblue \"> Personal Website:"+website+"</h3>");
		
		pw.println("<h1><a href='Session.html'>Servlet Home</a></h1>");
	}

}
