package org.bibileanu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoGetParams extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		Enumeration<String> attrsNames = req.getParameterNames();
		
		out.println("<html><body>");
		while (attrsNames.hasMoreElements()) {
			String key = attrsNames.nextElement();
			String value = req.getParameter(key);
			out.println("'" + key + "' = '" + value + "'");
			out.println("<br/>");
		}
		out.println("</body></html>");
	}
}
