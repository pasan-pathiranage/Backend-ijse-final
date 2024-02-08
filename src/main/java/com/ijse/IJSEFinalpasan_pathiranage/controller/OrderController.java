package com.ijse.IJSEFinalpasan_pathiranage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.IJSEFinalpasan_pathiranage.dto.OrderDto;
import com.ijse.IJSEFinalpasan_pathiranage.entity.Order;
import com.ijse.IJSEFinalpasan_pathiranage.service.OrderService;



@RestController
@CrossOrigin(origins = "*")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        try {
            return ResponseEntity.status(200).body(orderService.getAllOrders());
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {

        Order order = orderService.getOrderById(id);

        if (order != null) {
            return ResponseEntity.status(200).body(order);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto) {
        try {
            return ResponseEntity.status(201).body(orderService.createOrder(orderDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to Create the Order");
        }
    }

    @PutMapping("/orers/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        try {
            return ResponseEntity.status(200).body(orderService.updateOrder(order, id));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id){

        Order order =orderService.getOrderById(id);

        if( order != null){
            orderService.deleteOrder(id);
            return ResponseEntity.status(200).body("Deleted Successfully");
        }else{
            return ResponseEntity.status(404).body("Item not Found");
        }
    }
}
