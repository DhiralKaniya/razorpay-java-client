package com.razorpay.client.controller;

import com.razorpay.Order;
import com.razorpay.client.model.Payment;
import com.razorpay.client.model.PaymentStatus;
import com.razorpay.client.razorpay.CustomPayment;
import com.razorpay.client.resourceModel.PaymentResourceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/payment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PaymentController {

    @Autowired
    private PaymentResourceProvider paymentResourceProvider;


    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    ResponseObject postPayment() {
        return (new ResponseObject(true, "payment has been made"));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/order_create")
    public @ResponseBody
    ResponseObject createOrder(@RequestBody PaymentRequestResponse paymentRequestResponse) {
        //step 1:- create an order
        Order order = CustomPayment.createOrderRequest(paymentRequestResponse.getAmount() * 100);
        //step 2:- create payment
        Payment payment = Payment.PaymentBuilder.Builder()
                .setRazorpayOrderId(order.get("id"))
                .setRazorpayStatus(order.get("status"))
                .setAmount(order.get("amount"))
                .setStatus(PaymentStatus.ORDER_CREATE)
                .setCreatedAt(order.get("created_at"))
                .Build();
        //step 3:- create payment object in our db
        paymentResourceProvider.save(payment);
        return new ResponseObject(true, "Order has been created.", payment);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/capture_payment/{paymentid}")
    public @ResponseBody
    ResponseObject capturePayment(@PathVariable("paymentid") String paymentid) {
        String result = CustomPayment.capturePayment(paymentid);
        if("success".equals(result)) {
            List<Payment> payments = paymentResourceProvider.fetchPaymentbyRazorpayPaymentId(paymentid);
            updateStatus(payments);
        }
        return new ResponseObject(true, "capture payment status", result);
    }
    private void updateStatus(List<Payment> payments){
        payments.stream().forEach(payment -> {
            payment.setStatus(PaymentStatus.PAYMENT_RECEIVED);
            payment.setRazorpayStatus("Captured");
            paymentResourceProvider.update(payment);
        });
    }
}
