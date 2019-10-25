/*
 *
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
// Copyright (c) 1995-96 by Cisco Systems, Inc.

package com.sun.jmx.snmp.daemon;

import java.util.logging.Level;

import static com.sun.jmx.defaults.JmxProperties.SNMP_ADAPTOR_LOGGER;

/**
 * This class retries any timed out inform requests. This class is for internal use.
 */

final class SnmpTimerServer extends Thread {

        // VARIABLES
    //----------

    private SnmpInformRequest req = null ;

    SnmpQManager snmpq = null ;

    // This boolean is used to stop handling requests while the corresponding SnmpQManager
    // is being destroyed.
    //
    boolean isBeingDestroyed = false;

    // CONSTRUCTORS
    //-------------

    public SnmpTimerServer (ThreadGroup grp, SnmpQManager q) {
        super(grp, "SnmpTimerServer") ;
        setName("SnmpTimerServer") ;
        snmpq = q ;
        start() ;
    }

    public synchronized void stopTimerServer() {

        if (isAlive()) {
            interrupt();
            try {
                // Wait until the thread die.
                //
                join();
            } catch (InterruptedException e) {
                // Ignore...
            }
        }
    }

    public void run() {
        Thread.currentThread().setPriority(Thread.NORM_PRIORITY);

        if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINER)) {
            SNMP_ADAPTOR_LOGGER.logp(Level.FINER, SnmpTimerServer.class.getName(),
                "run", "Timer Thread started");
        }

        while (true) {

            try {
                if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINER)) {
                    SNMP_ADAPTOR_LOGGER.logp(Level.FINER, SnmpTimerServer.class.getName(),
                        "run", "Blocking for inform requests");
                }
                if (req == null) {
                    req = snmpq.getTimeoutRequests() ;
                }
                if (req != null && req.inProgress()) {
                    if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINER)) {
                        SNMP_ADAPTOR_LOGGER.logp(Level.FINER, SnmpTimerServer.class.getName(),
                            "run", "Handle timeout inform request " + req.getRequestId());
                    }
                    req.action() ;
                    req = null ;
                }
                if (isBeingDestroyed == true)
                    break;
            } catch (Exception e) {
                if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                    SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpTimerServer.class.getName(),
                        "run", "Got unexpected exception", e);
                }
            } catch (ThreadDeath d) {
                if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                    SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpTimerServer.class.getName(),
                        "run", "ThreadDeath, timer server unexpectedly shutting down", d);
                }
                throw d ;
            } catch (OutOfMemoryError ome) {
                if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                    SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpTimerServer.class.getName(),
                        "run", "OutOfMemoryError", ome);
                }
                yield();
            } catch (Error err) {
                if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                    SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpTimerServer.class.getName(),
                        "run", "Received Internal error", err);
                }
            }
        }
    }

}
