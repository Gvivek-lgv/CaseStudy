package com.ibm.service;

import com.ibm.model.Order;
import com.ibm.model.OrderItem;
import com.ibm.model.Product;
import com.ibm.repository.OrderItemRepository;
import com.ibm.repository.OrderRepository;
import com.ibm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private OrderRepository orderRepo;

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepo.findAll();
    }

    public OrderItem saveOrderItem(OrderItem orderItem) {
        Product product = productRepo.findById(orderItem.getProduct().getId())
            .orElseThrow(() -> new RuntimeException("Product not found"));
        Order order = orderRepo.findById(orderItem.getOrder().getId())
            .orElseThrow(() -> new RuntimeException("Order not found"));

        orderItem.setProduct(product);
        orderItem.setOrder(order);
        orderItem.setPrice(product.getPrice());

        return orderItemRepo.save(orderItem);
    }

    public void deleteOrderItem(Long id) {
        orderItemRepo.deleteById(id);
    }
}
