package org.bibi.warlauncher;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.startup.VersionLoggerListener;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WebLauncher implements Runnable {
    private int securePort;
    private int unSecurePort;
    private String urlForDeploy;
    private String workingDirectory;
    private String warName;

    Tomcat tomcat = null;
    Service tomcatService = null;

    public WebLauncher() {
        tomcat = new Tomcat();
        tomcatService = tomcat.getService();
    }

    public void loadWar(String relativePathToWar, String warName) {
        final String METHOD_NAME = "loadWar :";
        String basePath = new File(".").getAbsolutePath();
        String catalinaHome = basePath + "/" + relativePathToWar;
        tomcat.setBaseDir(catalinaHome);
        tomcat.getServer().addLifecycleListener(new VersionLoggerListener());

        try {
            tomcat.addWebapp("", catalinaHome + "/" + warName);
        } catch (Exception e) {
            System.out.println(METHOD_NAME + e);
        }
    }

    public void launch() throws LifecycleException {
        tomcat.start();
        tomcat.getServer().await();
    }

    public Connector getTLSConnector() {
        String strKeystorePath = null;
        if (System.getProperty("ssl.keystore.path") != null) {
            strKeystorePath = System.getProperty("ssl.keystore.path");
        }
        String strKeyAlias = "tomcat";
        if (System.getProperty("ssl.key.alias") != null) {
            strKeyAlias = System.getProperty("ssl.key.alias");
        }
        Connector connector = new Connector();
        connector.setPort(securePort);
        connector.setSecure(true);
        connector.setScheme("https");
        connector.setAttribute("keyAlias", strKeyAlias);
        connector.setAttribute("keystorePass", "password");
        connector.setAttribute("keystoreType", "JKS");
        connector.setAttribute("keystoreFile", strKeystorePath);
        connector.setAttribute("sslProtocol", "TLS");
        connector.setAttribute("SSLEnabled", "true");
        connector.setAttribute("protocol", "HTTP/1.1");
        connector.setAttribute("clientAuth", "false");

        return connector;
    }

    public void addWebConnector(ConnectorDetails connDetails) {

        Connector connector = new Connector();
        connector.setPort(connDetails.getPort());
        connector.setSecure(connDetails.isSecure());
        if (connDetails.isSecure()) {
            connector.setScheme("https");
            connector.setAttribute("keyAlias", connDetails.getKeyAlias());
            connector.setAttribute("keystorePass", connDetails.getKeystorePass());
            connector.setAttribute("keystoreType", "JKS");
            connector.setAttribute("keystoreFile", connDetails.getPathToKeystore());
            connector.setAttribute("sslProtocol", "TLS");
            connector.setAttribute("SSLEnabled", "true");
            connector.setAttribute("protocol", "HTTP/1.1");
            connector.setAttribute("clientAuth", "false");
        }

        tomcatService.addConnector(connector);
    }

    public static Future executeJob(Runnable job) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        return executor.submit(job);
    }

    @Override
    public void run() {
        try {
            launch();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
