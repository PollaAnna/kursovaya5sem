package org.server.login;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.server.Main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            String query = exchange.getRequestURI().getQuery();
            Map<String, String> parameters = parseQuery(query);
            System.out.println(parameters);
            UserService userService = new UserService.UserServiceImplementation();
            String login = userService.login(parameters.get("login"), parameters.get("password"));
            if (login.isEmpty()) {
                Main.sendResponse(exchange, "auth fail", 400);
            } else {
                Main.sendResponse(exchange, login, 200);
            }
        }catch (Exception e){
            Main.sendResponse(exchange, e.getMessage(), 500);
        }
    }

    private Map<String, String> parseQuery(String query) {
        Map<String, String> parameters = new HashMap<>();
        if (query != null) {
            String[] pairs = query.split("&");
            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                if (keyValue.length == 2) {
                    String key = keyValue[0];
                    String value = keyValue[1];
                    parameters.put(key, value);
                }
            }
        }
        return parameters;
    }
}


