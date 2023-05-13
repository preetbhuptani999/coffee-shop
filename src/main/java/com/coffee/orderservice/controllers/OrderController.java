package com.coffee.orderservice.controllers;

import com.coffee.orderservice.dto.OrderDto;
import com.coffee.orderservice.dto.ResponseDto;
import com.coffee.orderservice.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(
            summary = "Create order",
            description = "API to create a new order",
            tags = "Post"
    )
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Order created successfully"),
            @ApiResponse(responseCode = "401", description = "You are not authorized to create an order"),
            @ApiResponse(responseCode = "403", description = "The resource you are trying to access is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found") })
    @PostMapping(value= "/order")
    public ResponseDto createOrder(@RequestBody OrderDto orderDto){

        orderService.createOrder(orderDto);
        return new ResponseDto("Success", "Order created successfully");
    }
}
