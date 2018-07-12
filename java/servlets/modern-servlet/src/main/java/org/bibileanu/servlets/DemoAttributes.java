package org.bibileanu.servlets; 

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletContext;

public class DemoAttributes extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		ServletContext ctx = this.getServletContext();
		Enumeration<String> attributes = ctx.getAttributeNames();
		while (attributes.hasMoreElements()) {
			String attrName = attributes.nextElement();
			Object attrVal = ctx.getAttribute(attrName);
			String className = attrVal.getClass().getName();
			out.println("'" + attrName + "':" + className);
			if (attrVal instanceof String) {
				out.println("val = '" + (String)attrVal + "'");
			}
            out.println("\n\n");
		}

		out.println("            " + "getContextPath() = " + req.getContextPath() );
		out.println("            " + "getLocalAddr() = " + req.getLocalAddr() );
		out.println("            " + "getLocalName() = " + req.getLocalName() );
		out.println("            " + "getPathInfo() = " + req.getPathInfo() );
		out.println("            " + "getPathTranslated() = " + req.getPathTranslated() );
		out.println("            " + "getQueryString() = " + req.getQueryString() );
		out.println("            " + "getRequestedURI() = " + req.getRequestURI() );
		out.println("            " + "getScheme() = " + req.getScheme() );
		out.println("            " + "getServerName() = " + req.getServerName() );
		out.println("            " + "getServletPath() = " + req.getServletPath() );
	}
}
