package main.java.com.bobozhuang.morethread;

import java.util.HashMap;
import java.util.Map;

/**
 * description：
 * author Hubery
 * date 2020-03-22
 * version v0.0.1
 * since v0.0.1
 **/
public class BuildThreadTwo {
    public static void main(String[] args) {
        HashMap<Object, Object> h = new HashMap<>();
        DemoActivity demoActivity = new DemoActivity();
        demoActivity.onCreate(h);
    }
}

class DemoActivity extends BaseActivity implements Runnable {

    @Override
    public void onCreate(Map savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {

    }
}