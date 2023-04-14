package com.example.session;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpSessionOne  extends HttpServlet {
  
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        try { /*Declaration of the get method*/
  
            response.setContentType("text/html"); // Setting the content type to text
            PrintWriter out = response.getWriter();
  
            String userName = request.getParameter("userName"); /*Fetching the contents of
                                                 the userName field from the form*/
            
            out.print("Welcome " + userName); // Printing the username
  
            HttpSession session = request.getSession(); /* Creating a new session*/
  
            session.setAttribute("uname", userName);
          
  
            out.print("<a href='servlet2'>   visit</a>"); // Link to the second servlet
  
            out.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}