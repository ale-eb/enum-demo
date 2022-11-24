package com.example.demo.utils;

import java.math.BigDecimal;

public class RateUtil {

    public static BigDecimal amountLessRate(BigDecimal amount, BigDecimal rate) {
        BigDecimal result = amount.multiply(rate).divide(new BigDecimal(100));
        return amount.add(result);
    }
}
