package com.ijse.IJSEFinalpasan_pathiranage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.IJSEFinalpasan_pathiranage.dto.OrderDto;
import com.ijse.IJSEFinalpasan_pathiranage.entity.Order;



@Service
public interface OrderService  {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order createOrder(OrderDto orderDTO);
    Order updateOrder(Order order, Long id);
    void deleteOrder(Long id);
    
}