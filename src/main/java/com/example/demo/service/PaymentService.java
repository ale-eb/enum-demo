package com.example.demo.service;

import com.example.demo.domain.Payment;

import java.math.BigDecimal;

public interface PaymentService {
    BigDecimal getFinalAmount(Payment payment);
}
