package gov.iti.jets.ecommiti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.iti.jets.ecommiti.dtos.OrderDTO;
import gov.iti.jets.ecommiti.dtos.OrderHasProductDTO;
import gov.iti.jets.ecommiti.mappers.OrderHasProductMapper;
import gov.iti.jets.ecommiti.models.OrderHasProduct;
import gov.iti.jets.ecommiti.models.OrderHasProductId;
import gov.iti.jets.ecommiti.repositories.OrderHasProductRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test/orderhasProduct")
public class OrderHasProductController {
    @Autowired
    private OrderHasProductRepository orderHasProductRepo;

    @PostMapping
    public void getOrderHasProduct(@RequestBody OrderHasProductDTO order) {
        OrderHasProductId id = new OrderHasProductId(order.getOrderDTO().getId(),order.getProductDTO().getId());
        order.setId(id);
        orderHasProductRepo.save(OrderHasProductMapper.INSTANCE.map(order));
    }
    
}
