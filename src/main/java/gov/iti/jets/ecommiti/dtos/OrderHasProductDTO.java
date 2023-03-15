package gov.iti.jets.ecommiti.dtos;

import gov.iti.jets.ecommiti.dtos.request.ProductDto;
import gov.iti.jets.ecommiti.dtos.response.OrderResponseDTO;
import gov.iti.jets.ecommiti.dtos.response.ProductResponseDTO;
import gov.iti.jets.ecommiti.models.OrderHasProductId;
import lombok.Data;

@Data
public class OrderHasProductDTO {
    OrderHasProductId id;
    ProductResponseDTO product;
    OrderResponseDTO order;
    int quantity;

}
