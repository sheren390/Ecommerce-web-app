package gov.iti.jets.ecommiti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.iti.jets.ecommiti.models.OrderHasProduct;
import gov.iti.jets.ecommiti.models.OrderHasProductId;

public interface OrderHasProductRepository extends JpaRepository<OrderHasProduct, OrderHasProductId> {
    
}
