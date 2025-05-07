package com.ibm.controller;
import com.ibm.model.CartItem;
import com.ibm.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/cart-items")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;
    @GetMapping("/user/{userId}")
    public List<CartItem> getCartItemsByUser(@PathVariable Long userId) {
        return cartItemService.getItemsByUser(userId);
    }
    @PostMapping
    public CartItem addItemToCart(@RequestBody CartItem item) {
        return cartItemService.addItemToCart(item);
    }
    @DeleteMapping("/{id}")
    public void removeItemFromCart(@PathVariable Long id) {
        cartItemService.removeItem(id);
    }
}





