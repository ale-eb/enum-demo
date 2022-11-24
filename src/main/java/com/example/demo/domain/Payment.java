package com.example.demo.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Payment {

    BigDecimal amount;
    PaymentType paymentType;
}
