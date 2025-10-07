package com.flynaut.FoodDeliverySystem.service;

import com.flynaut.FoodDeliverySystem.entity.CartItem;
import java.util.List;

public interface CartService {
    CartItem addToCart(CartItem item);
    List<CartItem> getCartItems(String sessionId);
    void removeItem(Long id);
    void clearCart(String sessionId);
}
