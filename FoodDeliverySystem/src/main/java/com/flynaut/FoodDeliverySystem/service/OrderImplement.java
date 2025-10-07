package com.flynaut.FoodDeliverySystem.service;

import com.flynaut.FoodDeliverySystem.entity.Order;
import com.flynaut.FoodDeliverySystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderImplement implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order placeOrder(Order order) {
        if (!"Jalgaon".equalsIgnoreCase(order.getCity())) {
            throw new RuntimeException("Sorry! We currently deliver only in Jalgaon.");
        }
        if (order.getStatus() == null || order.getStatus().isEmpty()) {
            order.setStatus("Pending");
        }
        order.setDate(LocalDate.now().toString());
        if(order.getUsername() == null || order.getUsername().isEmpty()){
            throw new RuntimeException("Username is required to place order.");
        }
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrderByUser(String username) {
        return orderRepository.findByUsernameIgnoreCase(username);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public void cancelOrder(long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus("Cancelled");
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void updateOrderStatus(Long id, String status) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        orderRepository.save(order);
    }
}
