package com.arkiv.tests.services;

import java.math.BigDecimal;

public interface FibonacciNumberService {

    /**
     * https://en.wikipedia.org/wiki/Square_number
     * Perfect square is an integer that is the square of an integer
     * @param num
     * @return
     */
    boolean isPerfectSquare(BigDecimal num);

    /**
     * https://en.wikipedia.org/wiki/Fibonacci_number#Recognizing_Fibonacci_numbers
     * A number is Fibonacci if and only if one or both of (5*n2 + 4) or (5*n2 – 4) is a perfect square
     * @param num
     * @return
     */
    boolean isFibonacciBigNumber(BigDecimal num);

    /**
     * boolean isPerfectSquare(int num);
     * boolean isFibonacciNumber(int number);
     */
}
