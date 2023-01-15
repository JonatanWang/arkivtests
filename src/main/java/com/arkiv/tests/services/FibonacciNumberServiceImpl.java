package com.arkiv.tests.services;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class FibonacciNumberServiceImpl implements FibonacciNumberService {
    private static final BigDecimal ZERO = BigDecimal.valueOf(0);
    private static final BigDecimal ONE = BigDecimal.valueOf(1);
    private static final BigDecimal TWO = BigDecimal.valueOf(2);
    private static final BigDecimal FOUR = BigDecimal.valueOf(4);
    private static final BigDecimal FIVE = BigDecimal.valueOf(5);

    @Override
    public boolean isPerfectSquare(BigDecimal num) {
        BigDecimal low = ZERO;
        BigDecimal high = num;

        while (low.compareTo(high) <= 0) {
            BigDecimal mid = low.add(high).divide(TWO).setScale(0, RoundingMode.DOWN);
            BigDecimal square = mid.multiply(mid);
            int comparison = square.compareTo(num);

            if (comparison == 0) {

                return true;
            } else if (comparison > 0) {
                high = mid.subtract(ONE);
            } else {
                low = mid.add(ONE);
            }
        }

        return false;
    }

    @Override
    public boolean isFibonacciBigNumber(BigDecimal num) {
        if (num.compareTo(ZERO) <= 0) {
            return false;
        }

        BigDecimal base = num.multiply(num).multiply(FIVE);
        BigDecimal testA = base.add(FOUR);
        BigDecimal testB = base.subtract(FOUR);

        return (isPerfectSquare(testA) || isPerfectSquare(testB));
    }
}
