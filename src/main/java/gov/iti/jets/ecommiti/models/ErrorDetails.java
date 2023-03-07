package gov.iti.jets.ecommiti.models;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class ErrorDetails {

        private String errorCode;
        private String errorMessage;
        // private Map<String, Object> additionalData = new HashMap<>();

}
