package com.razorpay.client.resourceProvider;

import com.razorpay.client.model.Payment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentResource extends CrudRepository<Payment, Integer> {
    @Query(value = "SELECT * FROM nd_core_payment where razorpay_payment_id = ?1", nativeQuery = true)
    List<Payment> findByRazorpayPaymentId(String razorpayPaymentId);

    @Query(value = "SELECT * FROM nd_core_payment where razorpay_order_id = ?1", nativeQuery = true)
    List<Payment> findByRazorpayOrderId(String razorpayOrderId);
}
