package com.bobozhuang.spring.test.proxy;

import org.springframework.stereotype.Service;

/**
 * description：
 * author Hubery
 * date 2020-11-04
 * version v0.0.1
 * since v0.0.1
 **/
@Service(value = "calculator")
public class CalculatorImpl implements Calculator {
    @Override
    public Double divide(Double a, Double b) {
        return a / b;
    }
}