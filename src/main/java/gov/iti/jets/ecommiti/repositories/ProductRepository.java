package gov.iti.jets.ecommiti.repositories;

import gov.iti.jets.ecommiti.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
