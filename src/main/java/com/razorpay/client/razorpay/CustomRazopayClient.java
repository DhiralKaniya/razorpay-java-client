package com.razorpay.client.razorpay;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

public class CustomRazopayClient {
    private static RazorpayClient razopayClient;

    public static RazorpayClient getRazopayClient() throws RazorpayException {
        if (razopayClient == null) {
            razopayClient = new RazorpayClient("<your-razorpay-key>", "<your-razorpay-secret>");
        }
        return razopayClient;
    }
}
