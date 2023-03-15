package gov.iti.jets.ecommiti.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.iti.jets.ecommiti.models.OrderHasProduct;
import gov.iti.jets.ecommiti.models.OrderHasProductId;

public interface OrderHasProductRepository extends JpaRepository<OrderHasProduct, OrderHasProductId> {

    @Query(" FROM OrderHasProduct o WHERE o.id.orderId = :id")
    Optional<List<OrderHasProduct>> findByOrderId(@Param("id") int id);
    
}
