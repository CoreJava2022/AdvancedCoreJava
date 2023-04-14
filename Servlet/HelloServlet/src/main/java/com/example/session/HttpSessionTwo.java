package com.example.session;


import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpSessionTwo extends HttpServlet {
  
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
    	try {
        /*Declaration of the get method*/
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
  
        HttpSession session = request.getSession(false);
       
  
        String uname = (String)session.getAttribute("uname");
        out.print("Hello " + uname);
  
        out.close();
    }
    catch (Exception e) {
        System.out.println(e);
    }
}
}