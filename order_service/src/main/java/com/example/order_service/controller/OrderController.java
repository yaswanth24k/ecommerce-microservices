package com.example.order_service.controller;

import com.example.order_service.entity.Order;
import com.example.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping
    public Order addorder(@RequestBody Order order)
    {
        return orderService.addorder(order);
    }

    @GetMapping("/{id}")
    public Order getorder(Long id)
    {
        return orderService.getorder(id);
    }

    @GetMapping
    public List<Order> getallorders()
    {
        return orderService.getallorder();
    }

    @PutMapping("/{id}")
    public Order updateorder(Long id)
    {
        return updateorder(id);
    }

    @DeleteMapping("/{id}")
    public void deleteorder(Long id)
    {
        orderService.deleteorder(id);
    }



}
