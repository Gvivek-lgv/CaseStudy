package com.ibm.service;

import com.ibm.model.Order;
import com.ibm.model.OrderItem;
import com.ibm.model.Product;
import com.ibm.repository.OrderRepository;
import com.ibm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private ProductRepository productRepo;

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepo.findByUserId(userId);
    }

    public Order getOrderById(Long orderId) {
        return orderRepo.findById(orderId).orElse(null);
    }

    public Order placeOrder(Order order) {
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PLACED");

        double total = 0;
        for (OrderItem item : order.getItems()) {
            Product product = productRepo.findById(item.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            if (product.getQuantity() < item.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getName());
            }

            double discountedPrice = product.getPrice() * (1 - product.getDiscount() / 100);

            item.setOrder(order);
            item.setProduct(product);
            item.setPrice(discountedPrice);

            total += discountedPrice * item.getQuantity();

            product.setQuantity(product.getQuantity() - item.getQuantity());
            productRepo.save(product);
        }

        order.setTotalAmount(total);
        return orderRepo.save(order);
    }

    public void cancelOrder(Long orderId) {
        orderRepo.deleteById(orderId);
    }
}
