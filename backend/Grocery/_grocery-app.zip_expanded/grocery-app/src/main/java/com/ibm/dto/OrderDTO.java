package com.ibm.dto;

import java.time.LocalDate;

public class OrderDTO {
    private Long id;
    private Long userId;
    private LocalDate orderDate;
    private double totalAmount;

    public OrderDTO() {}

    public OrderDTO(Long id, Long userId, LocalDate orderDate, double totalAmount) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public LocalDate getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}
