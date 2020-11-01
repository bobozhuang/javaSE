package forkjoinpool;

import forkjoinpool.service.Calculator;

/**
 * description：通过普通的for循环 实现数组元素总和的相加 逻辑非常简单
 * author Hubery
 * date 2020-09-28
 * version v0.0.1
 * since v0.0.1
 **/
public class ForLoopCalculator implements Calculator {

    @Override
    public long sumUp(long[] numbers) {
        long total = 0;
        for (long i : numbers) {
            total += i;
        }
        return total;
    }
}
