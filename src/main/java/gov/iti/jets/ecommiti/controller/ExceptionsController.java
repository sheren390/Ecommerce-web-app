package gov.iti.jets.ecommiti.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import gov.iti.jets.ecommiti.models.ErrorDetails;

@ControllerAdvice
public class ExceptionsController {

    @ExceptionHandler
    public ResponseEntity<ErrorDetails> handleExceptions(Exception e) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(e.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
