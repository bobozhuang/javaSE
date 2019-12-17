import java.util.concurrent.locks.ReentrantLock;

/**
 * description£º
 * author Hubery
 * date 2019-10-21
 * version v0.0.1
 * since v0.0.1
 **/
public class ReentrantLockTest {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        for (int i = 1; i <= 3; i++) {
            lock.lock();
        }

        for(int i=1;i<=3;i++){
            try {

            } finally {
                lock.unlock();
            }
        }

    }

}
