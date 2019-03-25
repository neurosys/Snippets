package org.bibileanu.teste.start;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint(value = "/bibi")
public class Myws
{
    public Myws() {
        System.out.println("DEXTRACE:>> Myws() constructor");
    }
    @OnMessage
    public String onMessage(Session session, String message) {
        System.out.println("onMessage(): '" + message + "'");
        try {
            session.getBasicRemote().sendText("Bau!");
        } catch (Exception e) {
            System.out.println(e);
        }
        return "booooo!!!!";
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("on open reached");
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("on close reached");
    }

    @OnError
    public void onError(Session session, Throwable t) {
        System.out.println("error reached");
    }
}

