package gov.iti.jets.ecommiti.exception;

import java.sql.SQLException;

public class CategoryNotFoundExceptions extends RuntimeException {

    public CategoryNotFoundExceptions() {
        super("no category found");
    }

}
