package com.hello.controller.config;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletConfigExample extends HttpServlet {

	
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		 
		  ServletConfig servletConfig = getServletConfig();
		  
		  String email = servletConfig.getInitParameter("email");
		  
		  PrintWriter printWriter = response.getWriter();
		  
		  printWriter.println("Default Admin user name : "+email);
		  
		  /*MIME Type*/
		  response.setContentType("text/html");
		  String website  = getServletContext().getInitParameter("Application_Name");
		
		  printWriter.println("<h4  style=\"color:Tomato;\">" + website + "</h4>");
		  printWriter.println("<h4  style=\"color:Tomato;\">" + email + "</h4>");
	   }
}
