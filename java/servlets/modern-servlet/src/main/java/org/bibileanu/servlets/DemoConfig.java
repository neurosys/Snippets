package org.bibileanu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoConfig extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletConfig config = getServletConfig();
		Enumeration<String> configParamNames = config.getInitParameterNames();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Params for this servlet</h1>");		
		while (configParamNames.hasMoreElements()) {
			String key = configParamNames.nextElement();
			String value = config.getInitParameter(key);
			out.println("    '" + key + "'='" + value + "'");
			out.print("    <br/>");
		}
		
		out.println("<h1>Context params</h1>");
		ServletContext ctx = getServletContext();
		Enumeration<String> ctxParamNames = ctx.getInitParameterNames();
		while (ctxParamNames.hasMoreElements()) {
			String ctxKey = ctxParamNames.nextElement();
			String ctxParamVal = ctx.getInitParameter(ctxKey);
			out.println("    '" + ctxKey + "'='" + ctxParamVal + "'");
			out.println("    <br/>");
		}
		
		
		out.println("</body>");
		out.println("</html>");
	}

}
