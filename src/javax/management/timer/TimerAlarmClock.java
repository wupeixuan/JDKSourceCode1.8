/*
 * Copyright (c) 1999, 2012, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package javax.management.timer;

import java.util.Date;
import java.util.logging.Level;
import static com.sun.jmx.defaults.JmxProperties.TIMER_LOGGER;

/**
 * This class provides a simple implementation of an alarm clock MBean.
 * The aim of this MBean is to set up an alarm which wakes up the timer every timeout (fixed-delay)
 * or at the specified date (fixed-rate).
 */

class TimerAlarmClock extends java.util.TimerTask {

    Timer listener = null;
    long timeout = 10000;
    Date next = null;

    /*
     * ------------------------------------------
     *  CONSTRUCTORS
     * ------------------------------------------
     */

    public TimerAlarmClock(Timer listener, long timeout) {
        this.listener = listener;
        this.timeout = Math.max(0L, timeout);
    }

    public TimerAlarmClock(Timer listener, Date next) {
        this.listener = listener;
        this.next = next;
    }

    /*
     * ------------------------------------------
     *  PUBLIC METHODS
     * ------------------------------------------
     */

    /**
     * This method is called by the timer when it is started.
     */
    public void run() {

        try {
            //this.sleep(timeout);
            TimerAlarmClockNotification notif = new TimerAlarmClockNotification(this);
            listener.notifyAlarmClock(notif);
        } catch (Exception e) {
            TIMER_LOGGER.logp(Level.FINEST, Timer.class.getName(), "run",
                    "Got unexpected exception when sending a notification", e);
        }
    }
}
