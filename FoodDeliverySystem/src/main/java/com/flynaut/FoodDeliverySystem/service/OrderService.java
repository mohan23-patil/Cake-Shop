package com.flynaut.FoodDeliverySystem.service;

import com.flynaut.FoodDeliverySystem.entity.Order;

import java.util.List;

public interface OrderService {
    Order placeOrder(Order order);
    List<Order> getOrderByUser(String username);
    List<Order> getAllOrder();
    void cancelOrder(long id);
    void deleteOrder(long id);
    void updateOrderStatus(Long id, String status);
}
