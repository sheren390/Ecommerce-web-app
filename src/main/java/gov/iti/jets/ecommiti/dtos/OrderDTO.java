package gov.iti.jets.ecommiti.dtos;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import gov.iti.jets.ecommiti.models.OrderHasProduct;
import gov.iti.jets.ecommiti.models.Product;
import gov.iti.jets.ecommiti.models.User;
import lombok.Data;

@Data
public class OrderDTO {

    private Integer id;
    private UserDTO user;
    private Date date;
    private long totalPrice;
    private String orderStatus;

    private Set<OrderHasProduct> orderHasProducts = new HashSet<>();

}
