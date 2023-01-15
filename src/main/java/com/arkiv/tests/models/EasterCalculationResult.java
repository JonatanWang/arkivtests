package com.arkiv.tests.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EasterCalculationResult {
    private LocalDate easterDate;
    private int isOn15thApril;
}
