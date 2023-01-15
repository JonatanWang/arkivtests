package com.arkiv.tests.services;

import com.arkiv.tests.models.EasterCalculationResult;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class EasterCalculationServiceImpl implements EasterCalculationService {

    private static final int M = 24;
    private static final int N1 = 5;
    private static final int N2 = 6;

    @Override
    public EasterCalculationResult calculateEaster(int year) {
        if(year < 1900 || year > 2199) return null;
        var N = (year < 2100) ? N1 : N2;

        var a = year % 19;
        var b = year % 4;
        var c = year % 7;
        var d = (19 * a + M) % 30;
        var e = (2 * b + 4 * c + 6 * d + N) % 7;

        var month = (d + e < 10) ? 3 : 4;
        var day = month == 3 ? (d + e + 22) : (d + e -9);

        if(month == 3) {
            var easterDate = LocalDate.of(year, month, day);

            return new EasterCalculationResult(easterDate, -1);
        }

        if(month == 4 && day == 26) {
            day =  19;
            var easterDate = LocalDate.of(year, month, day);

            return new EasterCalculationResult(easterDate, 1);
        } else if(month == 4 && day == 25 && a > 10 && d == 28 && e == 6) {
            day = 18;
            var easterDate = LocalDate.of(year, month, day);

            return new EasterCalculationResult(easterDate, 1);
        } else {
            var easterDate = LocalDate.of(year, month, day);
            int isOn15theApril;
            if(day > 15) {
                isOn15theApril = 1;
            } else if (day < 15) {
                isOn15theApril = -1;
            } else
            {
                isOn15theApril = 0;
            }

            return new EasterCalculationResult(easterDate, isOn15theApril);
        }
    }
}
