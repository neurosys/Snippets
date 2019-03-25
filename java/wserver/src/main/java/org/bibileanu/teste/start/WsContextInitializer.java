package org.bibileanu.teste.start;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerContainer;
import org.apache.tomcat.websocket.server.WsContextListener;

public class WsContextInitializer extends WsContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("DEXTRACE:>> contextInitialized()");
        super.contextInitialized(sce);
        ServerContainer sc = (ServerContainer) sce // \\
                .getServletContext() // \\
                .getAttribute("javax.websocket.server.ServerContainer");

        try {
            sc.addEndpoint(Class.forName("org.bibileanu.teste.start.Myws"));
        } catch (Exception e) {
            System.out.println("DEXTRACE:>> WsContextInitializer::contextInitialized() exception");
            System.out.println(e);
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("DEXTRACE:>> contextDestroyed()");
    }
}
