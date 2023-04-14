package com.example.controller.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionOne extends HttpServlet{
protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
	response.setContentType("text/html");
	try(PrintWriter out = response.getWriter()){
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet SeesionOne </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> Servlet SeesionOne :  "+request.getContextPath() +"</h1>");
		String name = request.getParameter("name");
		
		System.out.println("Session Value : "+name);
        out.println("<h1>Hello "+ name+"," + "<br> Welcome to my website</h1>");
        out.println("<h1><a href='servlet2'>Go to servlet 2</a></h1>");
        //create a cookie
        Cookie c = new Cookie("user_name", name);
        response.addCookie(c);
        
		out.println("</body>");
		out.println("</body>"); 
		out.println("</html>");
		}
}
protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
	processRequest(request,response);
	
}
protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
	processRequest(request,response);
	
}
public String getServletInfo() {
    return "Short description";
}// </editor-fold>

}
