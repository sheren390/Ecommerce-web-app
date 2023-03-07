package gov.iti.jets.ecommiti;

import gov.iti.jets.ecommiti.dtos.ProductDTO;
import gov.iti.jets.ecommiti.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "name", source = "name")
    List<ProductDTO> map(List<Product> product);

}
