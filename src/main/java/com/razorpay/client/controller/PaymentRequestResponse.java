package com.razorpay.client.controller;

public class PaymentRequestResponse {
    private Integer paymentId;
    private Integer razorpayOrderId;
    private Integer razorpayPaymentId;
    private Integer amount;
    private String name;
    private String status;
    private String razorPayStatus;
    private String callbackUrl;
    private String key;


    public PaymentRequestResponse() {
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public PaymentRequestResponse(Integer paymentId, Integer razorpayOrderId, Integer razorpayPaymentId, Integer amount, String name, String status, String razorPayStatus, String callbackUrl, String key) {
        this.paymentId = paymentId;
        this.razorpayOrderId = razorpayOrderId;
        this.razorpayPaymentId = razorpayPaymentId;
        this.amount = amount;
        this.name = name;
        this.status = status;
        this.razorPayStatus = razorPayStatus;
        this.callbackUrl = callbackUrl;
        this.key = key;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getRazorpayOrderId() {
        return razorpayOrderId;
    }

    public void setRazorpayOrderId(Integer razorpayOrderId) {
        this.razorpayOrderId = razorpayOrderId;
    }

    public Integer getRazorpayPaymentId() {
        return razorpayPaymentId;
    }

    public void setRazorpayPaymentId(Integer razorpayPaymentId) {
        this.razorpayPaymentId = razorpayPaymentId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRazorPayStatus() {
        return razorPayStatus;
    }

    public void setRazorPayStatus(String razorPayStatus) {
        this.razorPayStatus = razorPayStatus;
    }

    public static class PaymentRequestResponseBuilder  {
        private Integer paymentId;
        private Integer razorpayOrderId;
        private Integer razorpayPaymentId;
        private Integer amount;
        private String name;
        private String status;
        private String razorPayStatus;
        private String callbackUrl;
        private String key;

        public static PaymentRequestResponseBuilder Builder(){
            return new PaymentRequestResponseBuilder();
        }
        private PaymentRequestResponseBuilder(){
        }

        public PaymentRequestResponseBuilder setPaymentId(Integer paymentId){
            this.paymentId = paymentId;
            return this;
        }
        public PaymentRequestResponseBuilder setRazorpayOrderId(Integer razorpayOrderId){
            this.razorpayOrderId = razorpayOrderId;
            return this;
        }
        public PaymentRequestResponseBuilder setRazorpayPaymentId(Integer razorpayPaymentId){
            this.razorpayPaymentId = razorpayPaymentId;
            return this;
        }
        public PaymentRequestResponseBuilder setAmount(Integer amount){
            this.amount = amount;
            return this;
        }
        public PaymentRequestResponseBuilder setName(String name){
            this.name= name;
            return this;
        }
        public PaymentRequestResponseBuilder setStatus(String status){
            this.status = status;
            return this;
        }
        public PaymentRequestResponseBuilder setRazorPayStatus(String razorPayStatus){
            this.razorPayStatus = razorPayStatus;
            return this;
        }
        public PaymentRequestResponseBuilder setCallbackUrl(String callbackUrl){
            this.callbackUrl = callbackUrl;
            return this;
        }
        public PaymentRequestResponseBuilder setKey(String key){
            this.key = key;
            return this;
        }
        public PaymentRequestResponse Build(){
            return new PaymentRequestResponse(paymentId, razorpayOrderId, razorpayOrderId, amount, name, status, razorPayStatus, callbackUrl, key);
        }
    }
}
