package com.ibm.service;

import com.ibm.model.Order;
import com.ibm.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepo.findByUserId(userId);
    }

    public Order getOrderById(Long orderId) {
        Optional<Order> order = orderRepo.findById(orderId);
        return order.orElse(null);
    }

    public Order placeOrder(Order order) {
        return orderRepo.save(order);
    }

    public void cancelOrder(Long orderId) {
        orderRepo.deleteById(orderId);
    }
}
