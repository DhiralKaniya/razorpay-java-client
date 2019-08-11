package com.razorpay.client.resourceModel;

import com.razorpay.client.model.Payment;
import com.razorpay.client.resourceProvider.PaymentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentResourceProvider {

    @Autowired
    private PaymentResource paymentResource;

    public Payment save(Payment saveData) {
        return paymentResource.save(saveData);
    }

    public Iterable<Payment> findAll() {
        return paymentResource.findAll();
    }

    public Optional<Payment> findById(Integer id) {
        return paymentResource.findById(id);
    }

    public Payment update(Payment payment) {
        return paymentResource.save(payment);
    }

    public boolean delete(Payment payment) {
        return deleteById(payment.getId());
    }

    public boolean deleteById(Integer id) {
        boolean status = false;
        if (findById(id).isPresent()) {
            paymentResource.deleteById(id);
            status = true;

        }
        return status;
    }

    public List<Payment> fetchPaymentbyRazorpayPaymentId(String razorpayPaymentId){
        return paymentResource.findByRazorpayPaymentId(razorpayPaymentId);
    }
    public List<Payment> fethcPaymentbyRazorpayOrderId(String razorpayOrderId){
        return paymentResource.findByRazorpayOrderId(razorpayOrderId);
    }
}
