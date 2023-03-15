package gov.iti.jets.ecommiti.mappers;

import gov.iti.jets.ecommiti.dtos.request.ProductDto;
import gov.iti.jets.ecommiti.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    Product mapToProduct(ProductDto productRequestDto);
    ProductDto mapToProductDto(Product product);
    List <Product> mapToProduct(List<ProductDto> productRequestDto);
    List <ProductDto> mapToProductDto(List<Product> product);

}
