package com.razorpay.client.controller;

public class ResponseObject {
    private boolean status;
    private String description;
    private Object responseObejct;

    public ResponseObject() {

    }

    public ResponseObject(boolean status, Object responseObejct) {
        this.status = status;
        this.responseObejct = responseObejct;
    }

    public ResponseObject(boolean status, String description) {
        this.status = status;
        this.description = description;
    }

    public ResponseObject(boolean status, String description, Object responseObejct) {
        this.status = status;
        this.description = description;
        this.responseObejct = responseObejct;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getResponseObejct() {
        return responseObejct;
    }

    public void setResponseObejct(Object responseObejct) {
        this.responseObejct = responseObejct;
    }

}
