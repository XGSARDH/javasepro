package com.sardh.ws;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/robin")
public class ChatEndpoint {
    private static Set<ChatEndpoint> webSocketSet = new HashSet<>();
    private Session session;

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("Received Message: " + message);
        broadcastMessage(message);
    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        System.out.println("New connection opened");
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        System.out.println("Connection closed.");
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("An error occurred: " + error.getMessage());
    }

    // Broadcasts a message to all connected clients
    private void broadcastMessage(String message) throws IOException {
        for (ChatEndpoint endpoint : webSocketSet) {
            try {
                synchronized (endpoint) {
                    endpoint.session.getBasicRemote().sendText(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error during broadcasting message");
            }
        }
    }
}
