package com.teducci.apigateway.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teducci.apigateway.configuration.ObjectToUrlEncodedConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class KeycloakService {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${keycloak.url-login}")
    private String urlUserLogin;

    @Value("${spring.security.oauth2.resource-server.opaque-token.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.resource-server.opaque-token.client-secret}")
    private String clientSecret;

    public Object userLogin(String username, String password) {
        Map<String, String> user = new HashMap<>();
        user.put("username", username);
        user.put("password", password);
        user.put("grant_type", "password");
        user.put("client_id", clientId);
        user.put("client_secret", clientSecret);
        restTemplate.getMessageConverters().add(new ObjectToUrlEncodedConverter(new ObjectMapper()));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<Map<String, String>> body = new HttpEntity<>(user, headers);
        return restTemplate.postForObject(urlUserLogin, body, Object.class);
    }
}
