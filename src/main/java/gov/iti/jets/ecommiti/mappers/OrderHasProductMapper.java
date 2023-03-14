package gov.iti.jets.ecommiti.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import gov.iti.jets.ecommiti.dtos.OrderDTO;
import gov.iti.jets.ecommiti.dtos.OrderHasProductDTO;
import gov.iti.jets.ecommiti.models.OrderHasProduct;

@Mapper(componentModel = "spring")
public interface OrderHasProductMapper {

    OrderHasProductMapper INSTANCE = Mappers.getMapper(OrderHasProductMapper.class);

    OrderHasProduct map(OrderHasProductDTO orderDTO);
}
