package org.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.server.login.LoginHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/login", new LoginHandler());

        server.setExecutor(null); // Use the default executor
        server.start();
        System.out.println("Server listening on port " + 8080);
        }


    public static void sendResponse(HttpExchange exchange, String body, int code) throws IOException {
        exchange.sendResponseHeaders(code, body.length());
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(body.getBytes());
        outputStream.close();
    }
}