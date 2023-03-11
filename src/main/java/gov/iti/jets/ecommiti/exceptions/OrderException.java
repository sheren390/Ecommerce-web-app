package gov.iti.jets.ecommiti.exceptions;

import org.springframework.http.HttpStatus;

public class OrderException extends RuntimeException {
    
    private HttpStatus httpStatus;
    
    public OrderException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
    
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
    
}
