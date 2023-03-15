package gov.iti.jets.ecommiti.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


import gov.iti.jets.ecommiti.dtos.OrderDTO;
import gov.iti.jets.ecommiti.dtos.request.OrderRequestDTO;
import gov.iti.jets.ecommiti.dtos.response.OrderResponseDTO;
import gov.iti.jets.ecommiti.models.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    
    //toEntity
    @Mapping(target = "id", ignore = true)
    Order toOrder(OrderDTO orderDTO);
    Order toOrder(OrderRequestDTO orderDTO);
    
    OrderDTO toOrderDto(Order order);

    @InheritInverseConfiguration
    List<OrderResponseDTO> toOrderDto(List<Order> orders);


    @InheritInverseConfiguration
    List<OrderResponseDTO> map(List<Order> orders);
    
}
