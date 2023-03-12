package gov.iti.jets.ecommiti.models;

import lombok.Data;

@Data
public class ErrorDetails {

        private boolean status = false;
        private String message;

}
