package gov.iti.jets.ecommiti.dtos.response;

import gov.iti.jets.ecommiti.models.OrderHasProductId;
import lombok.Data;

@Data
public class OrderHasProductResponseDTO {
    OrderHasProductId id;
    ProductResponseDTO product;
    // OrderResponseDTO order;
    int quantity;
}
