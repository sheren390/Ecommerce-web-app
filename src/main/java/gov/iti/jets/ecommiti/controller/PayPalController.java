package gov.iti.jets.ecommiti.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

@RestController
public class PayPalController {

    private final String CLIENT_ID = System.getenv("CLIENT_ID");
    private final String APP_SECRET = System.getenv("APP_SECRET");
    private final String baseURL = "https://api-m.sandbox.paypal.com"; // Sandbox environment

    // allow json body
    @PostMapping("/create-paypal-order")
    public ResponseEntity<?> createPaypalOrder() throws IOException {
        String accessToken = generateAccessToken();
        String url = baseURL + "/v2/checkout/orders";
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("intent", "CAPTURE");
        List<Map<String, Object>> purchaseUnits = new ArrayList<>();
        Map<String, Object> purchaseUnit = new HashMap<>();
        Map<String, Object> amount = new HashMap<>();
        amount.put("currency_code", "USD");
        amount.put("value", "100.00");
        purchaseUnit.put("amount", amount);
        purchaseUnits.add(purchaseUnit);
        requestBody.put("purchase_units", purchaseUnits);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
        return ResponseEntity.ok(response.getBody());
    }

    @PostMapping("/capture-paypal-order")
    public ResponseEntity<?> capturePaypalOrder(@RequestBody Map<String, String> requestBody) throws IOException {
        String orderId = requestBody.get("orderID");
        String accessToken = generateAccessToken();
        String url = baseURL + "/v2/checkout/orders/" + orderId + "/capture";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
        // TODO: store payment information such as the transaction ID
        return ResponseEntity.ok(response.getBody());
    }

    // generate an access token using client id and app secret
    private String generateAccessToken() throws IOException {
        String auth = Base64.getEncoder().encodeToString((CLIENT_ID + ":" + APP_SECRET).getBytes());
        String url = baseURL + "/v1/oauth2/token";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth(CLIENT_ID, APP_SECRET);
        HttpEntity<String> entity = new HttpEntity<>("grant_type=client_credentials", headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.getBody());
        return jsonNode.get("access_token").asText();
    }
}
