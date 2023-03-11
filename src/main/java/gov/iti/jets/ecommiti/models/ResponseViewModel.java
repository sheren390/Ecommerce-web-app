package gov.iti.jets.ecommiti.models;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ResponseViewModel<T> {

    T data;
    String status = "sucess";
    String message = "";
}
