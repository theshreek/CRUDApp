package com.shreek.crudapp.dto;

import lombok.Data;

@Data
public class ResponseDTO {
    private String message;
    private int statusCode;
    private Object Response;

}
