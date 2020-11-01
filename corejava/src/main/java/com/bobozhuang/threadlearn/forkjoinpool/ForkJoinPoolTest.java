package forkjoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Phaser;
import java.util.concurrent.RecursiveAction;

/**
 * description：     https://www.cnblogs.com/xiaoxiong2015/p/12705438.html
 * author Hubery
 * date 2020-09-28
 * version v0.0.1
 * since v0.0.1
 **/
public class ForkJoinPoolTest {

    public static void main(String... args) {
        ForkJoinPool common = ForkJoinPool.commonPool();
        Phaser phaser = new Phaser(200);
        common.invoke(new PhaserWaiter(phaser));
    }

    private static class PhaserWaiter extends RecursiveAction {
        private final Phaser phaser;

        private PhaserWaiter(Phaser phaser) {
            this.phaser = phaser;
            System.out.println(ForkJoinPool.commonPool().getPoolSize());
        }

        protected void compute() {
            if (phaser.getPhase() > 0) return; // we've passed first phase
            PhaserWaiter p1 = new PhaserWaiter(phaser);
            p1.fork();
            phaser.arriveAndAwaitAdvance();
            p1.join();
        }
    }

}
