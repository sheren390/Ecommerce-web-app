package gov.iti.jets.ecommiti.exception;

public class NoOrdersFoundException extends RuntimeException {
    public NoOrdersFoundException() {
        super("No orders yet");
    }
}
