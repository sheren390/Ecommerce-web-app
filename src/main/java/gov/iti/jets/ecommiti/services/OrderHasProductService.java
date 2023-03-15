package gov.iti.jets.ecommiti.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.iti.jets.ecommiti.dtos.OrderHasProductDTO;
import gov.iti.jets.ecommiti.exception.NoOrdersFoundException;
import gov.iti.jets.ecommiti.mappers.OrderHasProductMapper;
import gov.iti.jets.ecommiti.models.OrderHasProduct;
import gov.iti.jets.ecommiti.models.OrderHasProductId;
import gov.iti.jets.ecommiti.repositories.OrderHasProductRepository;
import lombok.Data;

@Data
@Service
public class OrderHasProductService {

    private final OrderHasProductRepository orderHasProductRepo;

    public OrderHasProductDTO createOrderWithProduct(OrderHasProduct orderHasProduct) {
        OrderHasProductId id = new OrderHasProductId(orderHasProduct.getOrder().getId(),
                orderHasProduct.getProduct().getId());
        orderHasProduct.setId(id);
        return OrderHasProductMapper.INSTANCE.map(orderHasProductRepo.save(orderHasProduct));
    }

    public List<OrderHasProductDTO> getOrderDetails(int id) {
        List<OrderHasProduct> orderHasProduct = new ArrayList<>();
        orderHasProduct = orderHasProductRepo.findByOrderId(id).orElseThrow(() -> new NoOrdersFoundException());
        System.out.println(orderHasProduct.get(1).getProduct());

        return OrderHasProductMapper.INSTANCE.map(orderHasProduct);

    }
}
