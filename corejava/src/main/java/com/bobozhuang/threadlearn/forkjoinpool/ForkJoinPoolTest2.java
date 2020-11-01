package forkjoinpool;

import forkjoinpool.service.Calculator;
import forkjoinpool.service.ExecutorServiceCalculator;
import forkjoinpool.service.ForkJoinCalculator;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

/**
 * description： 1-1千万的累加，根据cup线程数8分成8组，每组都是一个线程，然后放入8个固定线程数的池，最后把8个结果加起来。
 * author Hubery
 * date 2020-09-28
 * version v0.0.1
 * since v0.0.1
 **/
public class ForkJoinPoolTest2 {

    public static void main(String[] args) {

        //simpleAdd();
        fJAdd();
        streamAdd();
    }

    /**
     * 并行流底层还是Fork/Join框架，只是任务拆分优化得很好。
     */
    public static void streamAdd(){
        Instant start = Instant.now();
        long result = LongStream.rangeClosed(0, 10000000L).parallel().reduce(0, Long::sum);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms");

        System.out.println("结果为：" + result); // 打印结果500500
    }
    public static void fJAdd(){
        long[] numbers = LongStream.rangeClosed(1, 10000000).toArray();

        Instant start = Instant.now();
        Calculator calculator = new ForkJoinCalculator();
        long result = calculator.sumUp(numbers);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms");

        System.out.println("结果为：" + result); // 打印结果500500
    }

    public static void moreThreadAdd(){
        long[] numbers = LongStream.rangeClosed(1, 10000000).toArray();

        Instant start = Instant.now();
        Calculator calculator = new ExecutorServiceCalculator();
        long result = calculator.sumUp(numbers);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms");

        System.out.println("结果为：" + result); // 打印结果500500
    }

    public static void simpleAdd(){
        long[] numbers = LongStream.rangeClosed(1, 10000000).toArray();

        Instant start = Instant.now();
        Calculator calculator = new ForLoopCalculator();
        long result = calculator.sumUp(numbers);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms");

        System.out.println("结果为：" + result);
    }
}
