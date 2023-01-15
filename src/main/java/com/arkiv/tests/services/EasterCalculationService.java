package com.arkiv.tests.services;

import com.arkiv.tests.models.EasterCalculationResult;

public interface EasterCalculationService {
    EasterCalculationResult calculateEaster(int year);
}
/**
 * 用Y表示年份，mod运算指整数除法的余数（例如13 mod 5 = 3，详细请参见同余）。
 *
 * 东正教会所用的儒略历取M=15,N=6，西方教会所用的公历的取法参见下表：
 *
 *   年份      M   N
 * 1583-1699  22   2
 * 1700-1799  23   3
 * 1800-1899  23   4
 * 1900-2099  24   5
 * 2100-2199  24   6
 * 2200-2299  25   0
 * a = Y mod 19
 * b = Y mod 4
 * c = Y mod 7
 * d = (19a + M) mod 30
 * e = (2b + 4c + 6d + N) mod 7
 * 若d+e < 10则复活节在3月(d+e+22)日，反则在4月(d+e-9)日，除了两个特殊情况：
 *
 * 若公式算出的日期是4月26日，复活节在4月19日；
 * 若公式算出的日期是4月25日，同时d=28、e=6和a>10，复活节应在4月18日。
 * https://en.wikipedia.org/wiki/Date_of_Easter
 */