package gov.iti.jets.ecommiti.services;

import java.util.List;

public interface CrudServices<T,ID> {
    List<T> getAll();
}
