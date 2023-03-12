package gov.iti.jets.ecommiti.models;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ResponseViewModel {

    Object data;
    boolean status = true;
    String message = "";
}
