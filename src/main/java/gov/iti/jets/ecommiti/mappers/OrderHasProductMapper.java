package gov.iti.jets.ecommiti.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import gov.iti.jets.ecommiti.dtos.OrderHasProductDTO;
import gov.iti.jets.ecommiti.models.OrderHasProduct;

@Mapper(componentModel = "spring")
public interface OrderHasProductMapper {

    OrderHasProductMapper INSTANCE = Mappers.getMapper(OrderHasProductMapper.class);

    @InheritInverseConfiguration
    OrderHasProductDTO map(OrderHasProduct order);

    @InheritInverseConfiguration
    List<OrderHasProductDTO> map(List<OrderHasProduct> orders);
}
