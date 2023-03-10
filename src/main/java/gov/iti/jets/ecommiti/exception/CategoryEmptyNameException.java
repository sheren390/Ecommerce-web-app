package gov.iti.jets.ecommiti.exception;

public class CategoryEmptyNameException extends RuntimeException {

    public CategoryEmptyNameException() {
        super("Category name can't be empty");
    }

}
