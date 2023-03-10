package gov.iti.jets.ecommiti.dtos.response;

import java.util.HashSet;
import java.util.Set;

import gov.iti.jets.ecommiti.models.Product;
import lombok.Data;

@Data
public class CategoryResponseDto {
    private Integer id;
    private String name;
    private String image;
    private String description;
    // TODO waiting product dto
    // private Set<Product> products = new HashSet<Product>(0);
}
