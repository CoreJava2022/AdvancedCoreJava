package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CollegeName extends HttpServlet {

	public void doGet(HttpServletRequest request , HttpServletResponse response)throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.print("<h1 style=\"color:green;\"> Dr.D.Y.Patil COLLEGE ARTS AND COMMERCE COLLEGE AKURDI PUNE-33.</h1>");
	}
}
