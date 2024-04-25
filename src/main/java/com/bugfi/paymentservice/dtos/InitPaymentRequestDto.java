package com.bugfi.paymentservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitPaymentRequestDto {
    private Long referenceId;
    private String email;
}
