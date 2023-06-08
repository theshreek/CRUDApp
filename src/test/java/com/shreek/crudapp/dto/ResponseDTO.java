package com.shreek.crudapp.dto;

public class ResponseDTO {
    private String message;
    private int statusCode;
    private Object Response;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Object getResponse() {
        return Response;
    }

    public void setResponse(Object response) {
        Response = response;
    }
}
