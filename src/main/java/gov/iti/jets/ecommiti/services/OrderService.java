package gov.iti.jets.ecommiti.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import gov.iti.jets.ecommiti.dtos.OrderDTO;
import gov.iti.jets.ecommiti.dtos.request.OrderRequestDTO;
import gov.iti.jets.ecommiti.dtos.response.OrderResponseDTO;
import gov.iti.jets.ecommiti.exceptions.OrderException;
import gov.iti.jets.ecommiti.mappers.OrderMapper;
import gov.iti.jets.ecommiti.models.Order;
import gov.iti.jets.ecommiti.models.OrderHasProduct;
import gov.iti.jets.ecommiti.models.Product;
import gov.iti.jets.ecommiti.repositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    public List<OrderResponseDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orderMapper.toOrderDto(orders);
    }

    public OrderDTO getOrderById(Integer id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderException(HttpStatus.NOT_FOUND, "Order not found with id " + id));

        return orderMapper.toOrderDto(order);

    }

    public OrderDTO updateOrder(Integer id, OrderRequestDTO orderDTO) {
        orderDTO.setId(id);

        return orderMapper.toOrderDto(orderRepository.save(orderMapper.toOrder(orderDTO)));
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = orderMapper.toOrder(orderDTO);
        Order savedOrder = orderRepository.save(order);

        return orderMapper.toOrderDto(savedOrder);
    }

    public void deleteOrder(Integer id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderException(HttpStatus.NOT_FOUND, "Order not found with id " + id));

        order.setOrderStatus("Canceled");
        orderRepository.save(order);
    }

    public List<OrderResponseDTO> getAllOrdersByUserId(Integer id) {
        return OrderMapper.INSTANCE.map(orderRepository.findAllOrdersByUserId(id));
    }

    public void changeOrderSatus(Integer id, String status) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderException(HttpStatus.NOT_FOUND, "Order not found with id " + id));

        order.setOrderStatus(status);
        orderRepository.save(order);
    }

}
