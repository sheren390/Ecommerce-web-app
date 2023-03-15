package gov.iti.jets.ecommiti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.iti.jets.ecommiti.dtos.OrderDTO;
import gov.iti.jets.ecommiti.dtos.request.OrderRequestDTO;
import gov.iti.jets.ecommiti.dtos.response.OrderResponseDTO;
import gov.iti.jets.ecommiti.models.Order;
import gov.iti.jets.ecommiti.services.OrderService;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/test/orders")

public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderResponseDTO> getAllOrders() {

        return orderService.getAllOrders();
    }

    @GetMapping("/user/{id}")
    public List<OrderResponseDTO> getAllOrdersByUserId(@PathVariable Integer id) {

        return orderService.getAllOrdersByUserId(id);
    }

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}")
    public OrderDTO updateOrder(@PathVariable Integer id, @RequestBody OrderRequestDTO updatedOrder) {

        return orderService.updateOrder(id, updatedOrder);
    }

    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO order) {
        return orderService.createOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
    }

    @PutMapping("changeStatus/{id}")
    public void changeOrderSatus(@PathVariable Integer id, @RequestBody String status) {
        orderService.changeOrderSatus(id, status);
    }

}
