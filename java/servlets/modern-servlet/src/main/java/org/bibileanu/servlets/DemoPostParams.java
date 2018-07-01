package org.bibileanu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoPostParams extends HttpServlet {
	
	public void printForm(PrintWriter out) throws ServletException, IOException {
		
		

		out.println("<form action=\"/demopostparams\" target=\"self\" method=\"POST\">");
        out.println("   <fieldset>");
        out.println("       <legend>Personal info:</legend>");
        out.println("       <br/>");
        out.println("       Name:");
        out.println("       <br/>");
        out.println("       <input type=\"text\" name=\"name\" value=\"bibi\">");
        out.println("       <br/>");
        out.println("       Password:");
        out.println("       <br/>");
        out.println("       <input type=\"password\" name=\"password\" value=\"gigi\">");
        out.println("       <br/>");
        out.println("       <br/>");
        out.println("       <input type=\"submit\" name=\"didi\" value=\"pipi\">");
        out.println("       <br/>");
        out.println("       <br/>");
        out.println("       <input type=\"submit\" name=\"cici\" value=\"titi\">");
        out.println("   </fieldset>");
		out.println("</form>");

        out.println("</body></html>");
	}
	
	public void printBegining(PrintWriter out) {
		
		out.println("<html><body>");
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		printBegining(out);
		printForm(out);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		printBegining(out);
		
		Enumeration<String> attrNames = req.getParameterNames();
		while (attrNames.hasMoreElements()) {
			String name = attrNames.nextElement();
			String value = req.getParameter(name);
			out.println("'" + name + "' = '" + value + "'");
			out.println("<br/>");
		}
		printForm(out);
	}
}
