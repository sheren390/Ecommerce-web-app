package gov.iti.jets.ecommiti.dtos.response;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private Integer id;
    private String name;
    private String description;
    private int quantity;
    private long price;
    private String image;
    private CategoryResponseDto category;

}
