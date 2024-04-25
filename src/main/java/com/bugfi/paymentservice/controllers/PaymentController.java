package com.bugfi.paymentservice.controllers;

import com.bugfi.paymentservice.dtos.InitPaymentRequestDto;
import com.bugfi.paymentservice.services.PaymentService;
import com.razorpay.RazorpayException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;

    @PostMapping("/")
    public String initPayment(@RequestBody InitPaymentRequestDto requestDto) throws RazorpayException {
//        return "Order Id: " + requestDto.getReferenceId() + "\nEmail: " + requestDto.getEmail();      // Debug: It works
        return paymentService.initPayment(requestDto.getReferenceId(), requestDto.getEmail());
    }
}
