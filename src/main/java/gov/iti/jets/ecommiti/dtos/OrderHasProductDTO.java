package gov.iti.jets.ecommiti.dtos;

import gov.iti.jets.ecommiti.dtos.request.ProductDto;
import gov.iti.jets.ecommiti.models.OrderHasProductId;
import lombok.Data;

@Data
public class OrderHasProductDTO {
    OrderHasProductId id;
    ProductDto productDTO;
    OrderDTO orderDTO;
    int quantity; 
    
}
