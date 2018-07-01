package org.bibileanu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoHeaders extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Enumeration<String> headers = req.getHeaderNames();
		out.println("<html>");
		out.println("    <body>");
		while (headers.hasMoreElements()) {
			String key = headers.nextElement();
			String h = req.getHeader(key);
			out.println("    " + key + ": " + h);
			out.println("    <br/>");
		}
		out.println("    </body>");
		out.println("</html>");
	}

}
