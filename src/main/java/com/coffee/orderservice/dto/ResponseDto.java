package com.coffee.orderservice.dto;

public class ResponseDto {

    private String type;
    private String message;

    public ResponseDto(String type, String message) {
        this.message = message;
        this.type = type;
    }
}
