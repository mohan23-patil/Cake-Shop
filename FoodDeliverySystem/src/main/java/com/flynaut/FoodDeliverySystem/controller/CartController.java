package com.flynaut.FoodDeliverySystem.controller;

import com.flynaut.FoodDeliverySystem.entity.CartItem;
import com.flynaut.FoodDeliverySystem.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:3000") // frontend allow
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public CartItem addToCart(@RequestBody CartItem item) {
        return cartService.addToCart(item);
    }

    @GetMapping("/{sessionId}")
    public List<CartItem> getCartItems(@PathVariable String sessionId) {
        return cartService.getCartItems(sessionId);
    }

    @DeleteMapping("/remove/{id}")
    public String removeItem(@PathVariable Long id) {
        cartService.removeItem(id);
        return "Item removed from cart";
    }

    @DeleteMapping("/clear/{sessionId}")
    public String clearCart(@PathVariable String sessionId) {
        cartService.clearCart(sessionId);
        return "Cart cleared successfully";
    }
}

