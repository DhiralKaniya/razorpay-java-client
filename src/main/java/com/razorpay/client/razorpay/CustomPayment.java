package com.razorpay.client.razorpay;

import com.razorpay.Order;
import com.razorpay.Payment;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CustomPayment {

    private static final Logger log = LoggerFactory.getLogger(CustomPayment.class);

    public static List<Payment> getAllPayment() {
        List<Payment> customPayments = new ArrayList<>();
        try {
            customPayments = CustomRazopayClient.getRazopayClient().Payments.fetchAll();
        } catch (RazorpayException e) {
            log.error("Error when fetching a payment from razopay", e);
        }
        return customPayments;
    }

    public static List<Payment> getAllPayment(int count, int skip) {
        List<Payment> customPayments = new ArrayList<>();
        try {
            JSONObject paymentRequest = new JSONObject();
            paymentRequest.put("count", count);
            paymentRequest.put("skip", skip);
            customPayments = CustomRazopayClient.getRazopayClient().Payments.fetchAll(paymentRequest);
        } catch (RazorpayException e) {
            log.error("Error when fetching a payment from razopay", e);
        }
        return customPayments;
    }


    public static Order createOrderRequest(Integer amount) {
        Order order = null;
        try {
            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", amount);
            orderRequest.put("currency", "INR");
            orderRequest.put("payment_capture", false);
            order = CustomRazopayClient.getRazopayClient().Orders.create(orderRequest);
        } catch (RazorpayException e) {
            log.error("Error while creating an order razorpay", e);
        }
        return order;
    }

    public static String capturePayment(String paymentid) {
        try {
            Payment paymentDetails = CustomRazopayClient.getRazopayClient().Payments.fetch(paymentid);
            int amount = paymentDetails.get("amount");
            JSONObject options = new JSONObject();
            options.put("amount", amount);
            options.put("currency", "INR");
            CustomRazopayClient.getRazopayClient().Payments.capture(paymentid, options);
            return "success";
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }
}
