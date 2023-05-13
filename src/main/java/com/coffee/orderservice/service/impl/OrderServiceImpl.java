package com.coffee.orderservice.service.impl;

import com.coffee.orderservice.domain.Order;
import com.coffee.orderservice.domain.OrderDetails;
import com.coffee.orderservice.domain.enums.Status;
import com.coffee.orderservice.dto.ItemDto;
import com.coffee.orderservice.dto.OrderDto;
import com.coffee.orderservice.repositories.OrderDetailsRepository;
import com.coffee.orderservice.repositories.OrderRepository;
import com.coffee.orderservice.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final OrderRepository orderRepository;

    private final OrderDetailsRepository orderDetailsRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderDetailsRepository orderDetailsRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailsRepository = orderDetailsRepository;
    }

    @Override
    public void createOrder(OrderDto orderDto) {

        log.info("OrderServiceImpl | createOrder | OrderDto: {}", orderDto);

        // Code to validate if customer exists (we need to call customers service API)

        // Create a new record in Orders table
        Order order = orderRepository.save(new Order(orderDto.getCustomerId(), Status.CREATED));

        for (ItemDto itemDto: orderDto.getItemDtos()) {
            // Code to validate if product exists (we need to call products service API)

            // Create a new record in OrderDetails table
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrder(order);
            orderDetails.setProductId(itemDto.getProductId());
            orderDetails.setQuantity(itemDto.getQuantity());
            orderDetailsRepository.save(orderDetails);
        }

        // Send email to buyer
        sendEmailToBuyer(orderDto.getCustomerId(), order.getId());

    }

    @Override
    public void sendEmailToBuyer(long customerId, long orderId) {
        try{
            log.info("request received to send email to customer {} for order {}", customerId, orderId);

            // Code to send email to the user (we need to call email service API)

            log.info("successfully sent email to customer {} for order {}", customerId, orderId);
        }
        catch (Exception exception){
            log.error("unable to send email to customer {} for order {}. Error message: {}", customerId, orderId,
                    exception.getMessage());
        }
    }
}
