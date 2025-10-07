package com.flynaut.FoodDeliverySystem.service;

import com.flynaut.FoodDeliverySystem.entity.CartItem;
import com.flynaut.FoodDeliverySystem.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartImplement implements CartService {

    private final CartRepository cartRepository;

    public CartImplement(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public CartItem addToCart(CartItem item) {
        return cartRepository.save(item);
    }

    @Override
    public List<CartItem> getCartItems(String sessionId) {
        return cartRepository.findBySessionId(sessionId);
    }

    @Override
    public void removeItem(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public void clearCart(String sessionId) {
        List<CartItem> items = cartRepository.findBySessionId(sessionId);
        cartRepository.deleteAll(items);
    }
}