package com.natestgeorge.paperweight;

import com.corundumstudio.socketio.listener.*;
import com.corundumstudio.socketio.*;
import com.corundumstudio.socketio.Configuration;
import org.atmosphere.nettosphere.Config;
import org.atmosphere.nettosphere.Nettosphere;

import java.util.logging.Logger;

/**
 * Manages the SocketIO server.
 */
public class SocketServer {
    private Nettosphere server;
    private String hostname = "localhost";
    private int port = 9092;
    private Logger logger;

    public SocketServer(Logger logger) {
        this.logger = logger;
        server = new Nettosphere.Builder().config(
            new Config.Builder()
                .port(port)
                .host(hostname)
                .resource(SocketIOChatAtmosphereHandler.class)
                .build())
            .build();
    }

    /**
     * Start the SocketIO server.
     */
    public void start() {
        server.start();
        logger.info("Paperweight Socket server started at " + hostname + ":" + port);
    }

    /**
     * Send an event via the SocketIO server.
     * @param name Name of the event.
     * @param data Data to send in the event.
     */
    public void sendEvent(String name, Object data) {
        server.getBroadcastOperations().sendEvent(name, data);
    }

    private class OnConnect implements ConnectListener {

        private Logger logger;

        public OnConnect(Logger logger) {
            this.logger = logger;
        }

        @Override
        public void onConnect(SocketIOClient client) {
            logger.info("Got new connection");
            client.sendEvent("console_message", "hello!");
        }
    }
}
