package com.ibm.service;

import com.ibm.model.OrderItem;
import com.ibm.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepo;

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepo.findAll();
    }

    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepo.save(orderItem);
    }

    public void deleteOrderItem(Long id) {
        orderItemRepo.deleteById(id);
    }
}
