package com.example.demo.service;

import com.example.demo.domain.Payment;
import com.example.demo.domain.PaymentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

@SpringBootTest
public class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;

    @Test
    void getFinalAmount_withTypeCash_returnAmountWith5percentMore() {
        Payment payment = new Payment();
        payment.setAmount(new BigDecimal("100.00"));
        payment.setPaymentType(PaymentType.CASH);

        BigDecimal finalAmount = paymentService.getFinalAmount(payment);

        assertEquals(new BigDecimal("105.00"), finalAmount.setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void getFinalAmount_withTypeDebit_returnAmountWith10percentMore() {
        Payment payment = new Payment();
        payment.setAmount(new BigDecimal("100.00"));
        payment.setPaymentType(PaymentType.DEBIT);

        BigDecimal finalAmount = paymentService.getFinalAmount(payment);

        assertEquals(new BigDecimal("110.00"), finalAmount.setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void getFinalAmount_withTypeCredit_returnAmountWith20percentMore() {
        Payment payment = new Payment();
        payment.setAmount(new BigDecimal("100.00"));
        payment.setPaymentType(PaymentType.CREDIT);

        BigDecimal finalAmount = paymentService.getFinalAmount(payment);

        assertEquals(new BigDecimal("120.00"), finalAmount.setScale(2, RoundingMode.HALF_UP));
    }
}
