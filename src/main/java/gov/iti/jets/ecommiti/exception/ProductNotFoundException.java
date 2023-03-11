package gov.iti.jets.ecommiti.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException()
    {
        super("no product found");
    }
}
