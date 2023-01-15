package com.arkiv.tests.controllers;

import com.arkiv.tests.services.FibonacciNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/fib")
public class FibonacciCheckController {

    @Autowired
    private FibonacciNumberService fibonacciNumberService;

    @GetMapping("{input}")
    public boolean isFibonacciBigNumber(@PathVariable String input) {
        var number = new BigDecimal(input);

        return fibonacciNumberService.isFibonacciBigNumber(number);
    }
}
// https://www.bigprimes.net/archive/fibonacci/1