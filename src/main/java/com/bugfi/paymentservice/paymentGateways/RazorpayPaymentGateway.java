package com.bugfi.paymentservice.paymentGateways;

import com.razorpay.PaymentLink;
import org.json.JSONObject;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RazorpayPaymentGateway implements PaymentGateway {
//    @Value("${razorpay.key.id}")
//    private final String keyId;
//
//    @Value("${razorpay.key.secret}")
//    private final String keySecret;
//
//    public RazorpayPaymentGateway(String keyId, String keySecret) {
//        this.keyId = keyId;
//        this.keySecret = keySecret;
//    }

    @Override
    public String generatePaymentLink(Long referenceId, String email) throws RazorpayException {
        RazorpayClient razorpay = new RazorpayClient("[YOUR KEY ID]", "[YOUR KEY SECRET]");
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",1000);
        paymentLinkRequest.put("currency","INR");
//        paymentLinkRequest.put("accept_partial",true);
//        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",1691097057);
        paymentLinkRequest.put("reference_id",referenceId);
        paymentLinkRequest.put("description","Payment for policy no #23456");
        JSONObject customer = new JSONObject();
        customer.put("name","+919000090000");
        customer.put("contact","Gaurav Kumar");
        customer.put("email",email);
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
//        JSONObject notes = new JSONObject();
//        notes.put("policy_name","Jeevan Bima");
//        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://example-callback-url.com/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
        return payment.toString();
    }
}
