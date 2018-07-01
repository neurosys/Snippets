package org.bibileanu.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        out.println("<html>");
        out.println("   <head>");
        out.println("       <title>");
        out.println("           Hi there!");
        out.println("       </title>");
        out.println("   </head>");
        out.println("   <body>");
        out.println("       <h1>");
        out.println("           Nice to meet you!");
        out.println("       </h1>");
        out.println("   </body>");
        out.println("</html>");
    }

}
