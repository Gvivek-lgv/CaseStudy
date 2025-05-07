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
	        List<CartItem> existing = cartItemRepo.findByUserId(item.getUser().getId());
	        for (CartItem cart : existing) {
	            if (cart.getProduct().getId().equals(item.getProduct().getId())) {
	                cart.setQuantity(cart.getQuantity() + item.getQuantity());
	                return cartItemRepo.save(cart);
	            }
	        }
	        return cartItemRepo.save(item);
	    }
	
	    public void removeItem(Long id) {
	        cartItemRepo.deleteById(id);
	    }
	
	    public CartItem updateQuantity(Long cartItemId, int newQuantity) {
	        CartItem cartItem = cartItemRepo.findById(cartItemId)
	                .orElseThrow(() -> new RuntimeException("Cart item not found"));
	        cartItem.setQuantity(newQuantity);
	        return cartItemRepo.save(cartItem);
	    }
	}
