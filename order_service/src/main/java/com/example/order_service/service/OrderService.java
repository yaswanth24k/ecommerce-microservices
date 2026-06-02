package com.example.order_service.service;

import com.example.order_service.config.RestTemplateConfig;
import com.example.order_service.dto.ProductDto;
import com.example.order_service.dto.UserDto;
import com.example.order_service.entity.Order;
import com.example.order_service.exception.InsufficientStockException;
import com.example.order_service.exception.ProductNotFoundException;
import com.example.order_service.exception.UserNotFoundException;
import com.example.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    RestTemplate restTemplate;

    public Order addorder(Order order) {
        UserDto user = restTemplate.getForObject("http://localhost:8080/user/" + order.getUserid(), UserDto.class);
        if (user == null) {
            throw new UserNotFoundException("User with "+order.getUserid()+"not found");
        }
        ProductDto product = restTemplate.getForObject("http://localhost:8181/products/" + order.getProductid(), ProductDto.class);
        if (product == null) {
            throw new ProductNotFoundException("Product with "+order.getProductid()+"not found");
        }
        if (order.getQuantity()>product.getStock())
        {
            throw new InsufficientStockException("stock is only "+product.getStock());
        }
        order.setPrice(product.getPrice() * order.getQuantity());
        return orderRepository.save(order);
    }

    public Order getorder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> getallorder() {
        return orderRepository.findAll();
    }

    public Order updateorder(Long id, Order updatedOrder)
    {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setUserid(updatedOrder.getUserid());
        order.setProductid(updatedOrder.getProductid());
        order.setQuantity(updatedOrder.getQuantity());

        return orderRepository.save(order);
    }

    public void deleteorder(Long id) {
       orderRepository.deleteById(id);
    }

}
