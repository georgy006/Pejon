package com.example.pejon.model.dto.shelf_dto;

import lombok.Data;


public class DeleteShelfResponse {
    private boolean success;
    private String message;
    public DeleteShelfResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    // геттеры и сеттеры
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}

