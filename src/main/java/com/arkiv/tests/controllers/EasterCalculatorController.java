package com.arkiv.tests.controllers;

import com.arkiv.tests.models.EasterCalculationResult;
import com.arkiv.tests.services.EasterCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/easter")
public class EasterCalculatorController {

    @Autowired
    private EasterCalculationService easterCalculationService;

    @GetMapping("{year}")
    public EasterCalculationResult isFibonacciBigNumber(@PathVariable int year) {

        return easterCalculationService.calculateEaster(year);
    }
}
