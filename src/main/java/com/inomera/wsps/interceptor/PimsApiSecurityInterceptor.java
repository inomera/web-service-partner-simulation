package com.inomera.wsps.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpServletConnection;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class PimsApiSecurityInterceptor implements EndpointInterceptor {
    private static final String EXPECTED_USERNAME = "username";
    private static final String EXPECTED_PASSWORD = "password";

    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint) {
        String[] base64Credentials = getBase64Credentials();
        if (base64Credentials.length == 2) {
            String username = base64Credentials[0];
            String password = base64Credentials[1];
            if (EXPECTED_USERNAME.equals(username) && EXPECTED_PASSWORD.equals(password)) {
                return true;
            }
        }
        throw new SecurityException("Invalid credentials");
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object endpoint) {
        return false;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
        return false;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {
        // Nothing to do for now.
    }

    private String[] getBase64Credentials() {
        TransportContext transportContext = TransportContextHolder.getTransportContext();
        HttpServletConnection connection = (HttpServletConnection) transportContext.getConnection();
        HttpServletRequest request = connection.getHttpServletRequest();
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            throw new SecurityException("Invalid credentials");
        }
        String base64Credentials = authHeader.substring("Basic ".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials), StandardCharsets.UTF_8);
        return credentials.split(":", 2);
    }
}
