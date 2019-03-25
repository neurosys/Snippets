package org.bibi.tests;



import java.net.URI;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import javax.net.ssl.SSLContext;

/**
 * Example of a simple Echo Client.
 */
public class App
{
    public static void main(String[] args)
    {
//        String destUri = "ws://echo.websocket.org";


        String destUri = null;
        WebSocketClient client = null;

        boolean secure = true;
        if (secure) {
            destUri = "ws://127.0.0.1:9090/bibi";
            SslContextFactory sslContextFactory = new SslContextFactory();
            sslContextFactory.setTrustAll(true);
            client = new WebSocketClient(sslContextFactory);
        } /*
		else {
            destUri = "ws://172.16.0.100:9933/client";
            client = new WebSocketClient();
        }
        */

        SimpleEchoSocket socket = new SimpleEchoSocket();
        try
        {
            client.start();

            URI echoUri = new URI(destUri);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            Future<Session> future = client.connect(socket,echoUri,request);
            System.out.printf("Connecting to : %s%n",echoUri);

            Session session = future.get();
            session.getRemote().sendString("{\"id\":\"register\",\"name\":\"Citizen X\"}");


            // wait for closed socket connection.
            socket.awaitClose(50,TimeUnit.SECONDS);
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
        finally
        {
            try
            {
                client.stop();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}