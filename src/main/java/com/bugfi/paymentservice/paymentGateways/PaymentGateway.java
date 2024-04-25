package com.bugfi.paymentservice.paymentGateways;

import com.razorpay.RazorpayException;

public interface PaymentGateway {
    public String generatePaymentLink(Long referenceId, String email) throws RazorpayException;
}
