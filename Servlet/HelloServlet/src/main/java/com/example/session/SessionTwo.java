 package com.example.session;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionTwo  extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SessionTwo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SessionTwo at " + request.getContextPath() + "</h1>");

            //getting all the cookies / fetch all the cookies...
            Cookie[] cookies = request.getCookies();

            //flag variable...
            boolean f = false;//assume it by default
            String name = "";

            if (cookies == null) {
                out.println("<h1>You are new user, go to home page and submit your name!</h1>");
                return;
            } else {
                for (Cookie c : cookies) {//foreach loop...
                    String cookieName = c.getName();
                    if (cookieName.equals("user_name")) {

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

    //<editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
