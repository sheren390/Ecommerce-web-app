package gov.iti.jets.ecommiti.dtos.request;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import gov.iti.jets.ecommiti.dtos.UserDTO;
import gov.iti.jets.ecommiti.models.OrderHasProduct;
import lombok.Data;
@Data
public class OrderRequestDTO {
    
    private Integer id;
    private UserDTO user;
    private Date date;
    private long totalPrice;
    private String orderStatus;
   
    
    // private Set<OrderHasProduct>orderHasProducts = new HashSet<>();

}
