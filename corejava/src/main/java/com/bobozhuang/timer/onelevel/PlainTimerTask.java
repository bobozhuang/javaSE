package main.java.com.bobozhuang.timer.onelevel;

import java.util.Date;
import java.util.TimerTask;

/**
 * description：
 * author Hubery
 * date 2020-03-31
 * version v0.0.1
 * since v0.0.1
 **/
public class PlainTimerTask extends TimerTask {

    @Override
    public void run() {
        System.out.println(new Date());

    }
}
