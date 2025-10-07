package com.flynaut.FoodDeliverySystem.controller;

import com.flynaut.FoodDeliverySystem.entity.Order;
import com.flynaut.FoodDeliverySystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping("/place")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order){
        return ResponseEntity.ok(service.placeOrder(order));
    }

    @GetMapping("/user/{username}")
    public List<Order> getOrderByUser(@PathVariable String username){
        return service.getOrderByUser(username);
    }

    @GetMapping("/all")
    public List<Order> getAllOrder(){
        return service.getAllOrder();
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<String> cancelOrder(@PathVariable Long id) {
        service.cancelOrder(id);
        return ResponseEntity.ok("Order cancelled");
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<String> updateOrderStatus(@PathVariable Long id, @RequestParam String status) {
        service.updateOrderStatus(id, status);
        return ResponseEntity.ok("Status updated to: " + status);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id){
        service.deleteOrder(id);
        return ResponseEntity.ok("Order Deleted SuccessFully");
    }


}
