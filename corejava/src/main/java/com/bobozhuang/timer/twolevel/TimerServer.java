package main.java.com.bobozhuang.timer.twolevel;

/**
 * description：
 * author Hubery
 * date 2020-03-31
 * version v0.0.1
 * since v0.0.1
 **/

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Comment
 * <p>
 * Created on 2004-10-13
 * Modification history
 * <p>
 * @author	PowerEngine Expert Group, CSII
 * @version	1.0
 * @since	1.0
 */
public class TimerServer implements Server {

    private String name;
    private long delay;
    private long period;
    private Map data;
    private CoreController coreController;


    Timer timer;

    boolean isDaemon = false;

    private boolean started = false;

    /**
     *
     */
    public TimerServer() {
        super();
    }

    /* override
     * @see com.csii.pe.service.comm.Server#start()
     */
    public synchronized void start() {

        if (!this.started) {

            System.out.println("Starting... " + this.getName());
            timer = new Timer(isDaemon);
            TimerTask timerTask = new TimerTask() {

                public void run() {

                    handle();
                }
            };

            // timer.scheduleAtFixedRate(timerTask,delay,period);
            timer.schedule(timerTask, delay, period);

            this.started = true;

            System.out.println("Started... " + this.getName());
        }

    }

    private void handle() {

        internalHandle();

    }

    private void internalHandle() {

        String id = (String) data.get("transactionId");

//        Context context = new ScheduleContext(id, data);
//
//        try {
//            coreController.execute(context);
//        } catch (PeException e) {
//            log.error("coreController exception", e);
//        }

    }

    /* override
     * @see com.csii.pe.service.comm.Server#restart()
     */
    public void restart() {
    }

    /* override
     * @see com.csii.pe.service.comm.Server#shutdown()
     */
    public synchronized void shutdown() {

        if (this.started) {

            System.out.println("Stopping... " + this.getName());
            timer.cancel();
            this.started = false;
            System.out.println("Stopped... " + this.getName());
        }

    }

    /* override
     * @see com.csii.pe.service.comm.Server#isAlive()
     */
    public boolean isAlive() {

        return this.started;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param string
     */
    public void setName(String string) {
        name = string;
    }

    /**
     * @return
     */
    public long getDelay() {
        return delay;
    }

    /**
     * @return
     */
    public boolean isDaemon() {
        return isDaemon;
    }

    /**
     * @return
     */
    public long getPeriod() {
        return period;
    }

    /**
     * @param l
     */
    public void setDelay(long l) {
        delay = l;
    }

    /**
     * @param b
     */
    public void setDaemon(boolean b) {
        isDaemon = b;
    }

    /**
     * @param l
     */
    public void setPeriod(long l) {
        period = l;
    }

    /**
     * @return
     */
    public Map getData() {
        return data;
    }

    /**
     * @param map
     */
    public void setData(Map map) {
        data = map;
    }

    /**
     * @return
     */
    public CoreController getCoreController() {
        return coreController;
    }

    /**
     * @param controller
     */
    public void setCoreController(CoreController controller) {
        coreController = controller;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return this.name;
    }

}

class CoreController{

}