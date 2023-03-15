package gov.iti.jets.ecommiti.dtos.request;

import gov.iti.jets.ecommiti.dtos.UserDTO;
import gov.iti.jets.ecommiti.dtos.response.CategoryResponseDto;
import lombok.Data;

@Data
public class ProductDto {

    private Integer id;
    private String name;
    private String description;
    private int quantity;
    private long price;
    private String image;
    private CategoryResponseDto category;
    private UserDTO user;
    private boolean isDeleted;

}
