package gov.iti.jets.ecommiti.repositories;

import gov.iti.jets.ecommiti.models.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);
}
