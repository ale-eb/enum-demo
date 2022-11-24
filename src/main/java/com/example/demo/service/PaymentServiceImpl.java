package com.example.demo.service;

import com.example.demo.domain.Payment;
import com.example.demo.utils.RateUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class PaymentServiceImpl implements PaymentService{
    @Override
    public BigDecimal getFinalAmount(Payment payment) {
        return RateUtil.amountLessRate(new BigDecimal("100"), new BigDecimal("10"));
    }
}
