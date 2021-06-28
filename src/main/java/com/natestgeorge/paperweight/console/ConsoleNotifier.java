package com.natestgeorge.paperweight.notifier;

import com.natestgeorge.paperweight.server.SocketServer;
import com.natestgeorge.paperweight.console.ConsoleListener;

public class ConsoleNotifier extends Notifier implements ConsoleListener  {

    private SocketServer server;

    public ConsoleNotifier(SocketServer server) {
        this.server = server;
    }
    @Override
    public void onMessage(String message) {
        server.sendEvent("console_message", message);
    }

    @Override
    public void onEvent() {

    }
}
