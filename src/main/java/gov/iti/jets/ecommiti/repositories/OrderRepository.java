package gov.iti.jets.ecommiti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.iti.jets.ecommiti.dtos.OrderDTO;
import gov.iti.jets.ecommiti.models.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

    @Query("select o from Order o where o.user.id = :id")
    List<Order> findAllOrdersByUserId (@Param("id") Integer id);

   

    
}
