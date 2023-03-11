package gov.iti.jets.ecommiti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.iti.jets.ecommiti.models.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

   

    
}
