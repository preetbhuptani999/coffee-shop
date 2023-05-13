package com.coffee.orderservice.service;

import com.coffee.orderservice.dto.OrderDto;

public interface OrderService {
    void createOrder(OrderDto orderDto);

    void sendEmailToBuyer(long customerId, long orderId);
}
