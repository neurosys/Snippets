package org.bibi.warlauncher;

import lombok.Data;

@Data
public class ConnectorDetails {
    private int port;
    private boolean secure;
    private String pathToKeystore;
    private String keyAlias;
    private String keystorePass;
}
