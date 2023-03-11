package gov.iti.jets.ecommiti.dtos.request;

import lombok.Data;

@Data
public class ProductDto {

    private Integer id;
    private String name;
    private String description;
    private int quantity;
    private long price;
    private String image;
    private CategoryRequestDto category;
        // private User user;

}
