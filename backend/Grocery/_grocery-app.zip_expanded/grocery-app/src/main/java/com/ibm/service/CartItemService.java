package com.ibm.service;

import com.ibm.model.CartItem;
import com.ibm.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepo;

    public List<CartItem> getItemsByUser(Long userId) {
        return cartItemRepo.findByUserId(userId);
    }

    public CartItem addItemToCart(CartItem item) {
        return cartItemRepo.save(item);
    }

    public void removeItem(Long id) {
        cartItemRepo.deleteById(id);
    }
}
