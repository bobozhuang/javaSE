package main.java.com.bobozhuang.timer.lowlevel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * description：scheduledExecutionTime方法返回任务最近执行的时间
 * cancel方法是停止任务执行,Timer类中的cancel()方法作用是将任务队列中全部的任务进行清空
 * author Hubery
 * date 2020-03-31
 * version v0.0.1
 * since v0.0.1
 **/
public class TimerDemo {


    public static void main(String[] args) {

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int i = 0;
            @Override
            public void run() {


                System.out.println(DateFormatUtils.format(this.scheduledExecutionTime(), "yyyy-MM-dd HH:mm:ss"));
                i++;
                if (i>5){
                    this.cancel();
                }
            }
        };
        timer.schedule(task, 0, 2*1000);
    }
}

class DateFormatUtils{

    public static String format(Long time,String formatTime){

        Date date = new Date();
        //System.out.printf("date: " + date.toString());
        SimpleDateFormat sdf = new SimpleDateFormat(formatTime);
        String g = sdf.format(time);

        return g;
    }
}
