package com.ijse.IJSEFinalpasan_pathiranage.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.IJSEFinalpasan_pathiranage.dto.OrderDto;
import com.ijse.IJSEFinalpasan_pathiranage.entity.Item;
import com.ijse.IJSEFinalpasan_pathiranage.entity.Order;
import com.ijse.IJSEFinalpasan_pathiranage.repository.ItemRepository;
import com.ijse.IJSEFinalpasan_pathiranage.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();

    }

    @Override
    public Order createOrder(OrderDto orderDTO) {

        Order order = new Order();

        List<Long> items = orderDTO.getItems();
        List<Integer> quantities = orderDTO.getQuantities();
        Set<Item> itemsSet = new HashSet<>();

        order.setTotal(0.0);

        for (int i = 0; i < items.size(); i++) {
            Long itemId = items.get(i);
            Integer quantity = quantities.get(i);

            Item item = itemRepository.findById(itemId).orElse(null);

            Integer existingQuantity = item.getStock().getQty();

            existingQuantity -= quantity;
            item.getStock().setQty(existingQuantity);
            itemRepository.save(item);

            itemsSet.add(item);
            order.setTotal(order.getTotal() + (item.getPrice() * quantity));
        }

        order.setOrdertime(LocalDateTime.now());
        order.setItems(itemsSet);
        order.setDiscount(((order.getTotal() * 20) / 100));
        order.setTotal(order.getTotal() - order.getDiscount());
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order updateOrder(Order order, Long id) {
        Order exisistingOrder = orderRepository.findById(id).orElse(null);
        if (exisistingOrder != null) {
            exisistingOrder.setItems(order.getItems());
            exisistingOrder.setDiscount(order.getDiscount());
            exisistingOrder.setOrdertime(order.getOrdertime());
            exisistingOrder.setTotal(order.getTotal());
            return orderRepository.save(exisistingOrder);
        } else {
            return null;
        }
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
