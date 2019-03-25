package org.bibileanu.teste.start;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;
import javax.websocket.server.ServerEndpointConfig;

import org.apache.catalina.Context;
import org.apache.catalina.servlets.DefaultServlet;
import org.apache.catalina.startup.Tomcat;
import javax.websocket.server.ServerContainer;
import javax.servlet.ServletContext;

/**
 * EasyPack Tomcat Start
 * 
 */
public class Start {

	public static void main(String[] args) throws Exception {

		Tomcat tomcat = new Tomcat();

		tomcat.setPort(9090);

		Context ctx = tomcat.addContext("", null);
		ctx.addApplicationListener(WsContextInitializer.class.getName());
		Tomcat.addServlet(ctx, "default", new DefaultServlet());
		ctx.addServletMapping("/", "default");

		tomcat.getConnector().setAttribute("maxConnection", "-1");

		tomcat.start();

		//launchWebSocket(ctx);

		tomcat.getServer().await();

	}

	private static void launchWebSocket(Context sctx) {
		System.out.println("DEXTRACE:>> launchWebSocket(1) " + ServerContainer.class.getName());
		ServletContext ctx = sctx.getServletContext();
		ServerContainer serverContainer = (ServerContainer) ctx.getAttribute(ServerContainer.class.getName());
		String className = "org.bibileanu.teste.start.Myws";
		try {
			ServerEndpointConfig.Configurator x = new ServerEndpointConfig.Configurator();
			ServerEndpointConfig endpointConfig = ServerEndpointConfig.Builder
					.create(Class.forName(className), "/bibi")
					.configurator(x)
					.build();

			//serverContainer.setDefaultMaxTextMessageBufferSize(2_097_152);
			serverContainer.addEndpoint(endpointConfig);
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found '" + className + "'");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Well... there's an Exception...");
			e.printStackTrace();
		}
	}


	/**
	 * An HttpServlet example.
	 * 
	 * @return the servlet.
	 */
	private static HttpServlet helloWorldServlet() {

		return new HttpServlet() {

			private static final long serialVersionUID = 1L;

			@Override
			protected void doGet(HttpServletRequest req,
					HttpServletResponse resp) throws ServletException,
					IOException {

				resp.getWriter().println(
						"<h1>Welcome to the EasyPack Tomcat Embedded example</h1>");
			}
		};
	}
}