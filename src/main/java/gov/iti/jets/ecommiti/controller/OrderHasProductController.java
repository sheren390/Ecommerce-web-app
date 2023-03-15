package gov.iti.jets.ecommiti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import jakarta.transaction.Transactional;
import gov.iti.jets.ecommiti.services.OrderHasProductService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test/orderhasProduct")
public class OrderHasProductController {

    @Autowired
    public OrderHasProductService orderHasProductService;

    @GetMapping("/{id}")
    public List<OrderHasProductDTO> getOrderDetails(@PathVariable int id) {
        return orderHasProductService.getOrderDetails(id);
        
    }

    @PostMapping
    public OrderHasProductDTO getOrderHasProduct(@RequestBody OrderHasProduct orderHasProduct) {
       
        return orderHasProductService.createOrderWithProduct(orderHasProduct);
    }
    

}
