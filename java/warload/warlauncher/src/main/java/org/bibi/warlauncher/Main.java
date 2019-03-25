package org.bibi.warlauncher;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] argv) throws Exception {
        System.out.println("\n\nLoading application WAR...");

        WebLauncher wl = new WebLauncher();
        wl.loadWar("../mywar/target", "mywar-1.0-SNAPSHOT.war");

        ConnectorDetails secureConnector = new ConnectorDetails();
        secureConnector.setPort(9080);
        secureConnector.setSecure(true);
        secureConnector.setKeyAlias("tomcat");
        secureConnector.setKeystorePass("password");
        secureConnector.setPathToKeystore("../../mywar/keystore.jks");
        wl.addWebConnector(secureConnector);

        ConnectorDetails unSecureConnector = new ConnectorDetails();
        unSecureConnector.setPort(9408);
        unSecureConnector.setSecure(false);
        wl.addWebConnector(unSecureConnector);

        WebLauncher.executeJob(wl);
    }
}
