package com.razorpay.client.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "nd_core_payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    private Integer id;
    private String razorpayOrderId;
    private String razorpayPaymentId;
    private PaymentStatus status;
    private String razorpayStatus;
    private String receipt;
    private Date created_at;
    private Integer amount;


    public Payment() {
    }

    public Payment(Integer id, String razorpayOrderId, String razorpayPaymentId, PaymentStatus status, String razorpayStatus, String receipt, Date created_at, Integer amount) {
        this.id = id;
        this.razorpayOrderId = razorpayOrderId;
        this.razorpayPaymentId = razorpayPaymentId;
        this.status = status;
        this.razorpayStatus = razorpayStatus;
        this.receipt = receipt;
        this.created_at = created_at;
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public String getRazorpayStatus() {
        return razorpayStatus;
    }

    public void setRazorpayStatus(String razorpayStatus) {
        this.razorpayStatus = razorpayStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazorpayOrderId() {
        return razorpayOrderId;
    }

    public void setRazorpayOrderId(String razorpayOrderId) {
        this.razorpayOrderId = razorpayOrderId;
    }

    public String getRazorpayPaymentId() {
        return razorpayPaymentId;
    }

    public void setRazorpayPaymentId(String razorpayPaymentId) {
        this.razorpayPaymentId = razorpayPaymentId;
    }


    public static class PaymentBuilder {
        @Id
        @Column(name = "payment_id")
        private Integer id;
        private String razorpayOrderId;
        private String razorpayPaymentId;
        private PaymentStatus status;
        private String razorpayStatus;
        private String receipt;
        private Date created_at;
        private Integer amount;


        public static PaymentBuilder Builder() {
            return new PaymentBuilder();
        }

        public PaymentBuilder setAmount(Integer amount) {
            this.amount = amount;
            return this;
        }

        public PaymentBuilder setId(Integer id) {
            this.id = id;
            return this;
        }

        public PaymentBuilder setRazorpayOrderId(String razorpayOrderId) {
            this.razorpayOrderId = razorpayOrderId;
            return this;
        }

        public PaymentBuilder setRazorpayPaymentId(String razorpayPaymentId) {
            this.razorpayPaymentId = razorpayPaymentId;
            return this;
        }

        public PaymentBuilder setStatus(PaymentStatus status) {
            this.status = status;
            return this;
        }

        public PaymentBuilder setRazorpayStatus(String razorpayStatus) {
            this.razorpayStatus = razorpayStatus;
            return this;
        }

        public PaymentBuilder setReceipt(String receipt) {
            this.receipt = receipt;
            return this;
        }

        public PaymentBuilder setCreatedAt(Date createdAt) {
            this.created_at = createdAt;
            return this;
        }

        public Payment Build() {
            return new Payment(id, razorpayOrderId, razorpayPaymentId, status, razorpayStatus, receipt, created_at, amount);
        }
    }
}
