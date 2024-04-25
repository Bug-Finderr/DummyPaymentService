package com.bugfi.paymentservice.services;

import com.bugfi.paymentservice.paymentGateways.PaymentGateway;
import com.razorpay.RazorpayException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String initPayment(Long refernceId, String email) throws RazorpayException {
        return paymentGateway.generatePaymentLink(refernceId, email);
    }
}
