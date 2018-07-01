package org.bibileanu.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class DemoServlet extends HttpServlet {
    static Integer nrOfInstances = 0;
    int idInstance = 0;

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
        out.println("       <br>");
        out.println("       I am instance = " + idInstance);
        out.println("       <br>");
        out.println("       Nr of instances = " + nrOfInstances);
        out.println("   </body>");
        out.println("</html>");
    }

    public void init() throws ServletException {
        // If we don't use synchronized we can mess up the incrementation
        synchronized(nrOfInstances) {
            nrOfInstances++;
            idInstance = nrOfInstances;
            log.debug("DEXTRACE:>> init() nrOfInstances = " + nrOfInstances + " current instance = " + idInstance);
        }
    }

    public void destroy() {
        log.debug("DEXTRACE:>> destroy() current instance = " + idInstance);
    }
}
