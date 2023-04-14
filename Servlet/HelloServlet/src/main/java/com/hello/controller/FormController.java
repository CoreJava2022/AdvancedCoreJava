package com.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;//servlet-api.jar file required in build path


//@WebServlet(name = "FormController", urlPatterns = {"/MyForm"})
//@WebServlet("/MyForm")
@SuppressWarnings("serial")
public class FormController extends HttpServlet
{
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
	   
      String fname = request.getParameter("fName");
      String lName = request.getParameter("lName");
      String em = request.getParameter("email");
 
    
      response.setContentType("text/html");
      PrintWriter pw=response.getWriter();
      pw.write("<h2> Following data received sucessfully.. <h2> <br>");
      pw.write("<h3> First Name: "+ fname +" </h3>");
      pw.write("<h3> Last Name: "+ lName +" </h3>");
      pw.write("<h3> Email: "+ em +" </h3>");
      
      ServletConfig servletConfig = getServletConfig();
      String email = servletConfig.getInitParameter("email");
      pw.println("<h4  style=\"color:Tomato;\">" + email + "</h4>");
     
      
      String website  = getServletContext().getInitParameter("Application_Name");
	  pw.println("<h4  style=\"color:Tomato;\">" + website + "</h4>");
   }
}
