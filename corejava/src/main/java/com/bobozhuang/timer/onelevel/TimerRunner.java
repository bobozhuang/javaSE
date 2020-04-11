package main.java.com.bobozhuang.timer.onelevel;

import java.util.Timer;

/**
 * description：
 * author Hubery
 * date 2020-03-31
 * version v0.0.1
 * since v0.0.1
 **/
public class TimerRunner {
    public static void main(String [] args){
             Timer timer=new Timer();
             timer.schedule(new PlainTimerTask(), 2000L);
          }
}
