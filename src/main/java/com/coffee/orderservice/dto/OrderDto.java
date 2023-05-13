package com.coffee.orderservice.dto;

import java.util.List;

public class OrderDto {

    public long customerId;
    private List<ItemDto> itemDtos;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public List<ItemDto> getItemDtos() {
        return itemDtos;
    }

    public void setItemDtos(List<ItemDto> itemDtos) {
        this.itemDtos = itemDtos;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "customerId=" + customerId +
                ", itemDtos=" + itemDtos +
                '}';
    }
}
