/*
 * Copyright (c) 2001, 2006, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.jmx.snmp.internal;

import java.util.Hashtable;
import com.sun.jmx.snmp.SnmpEngineId;
import com.sun.jmx.snmp.SnmpUnknownModelLcdException;
import com.sun.jmx.snmp.SnmpUnknownSubSystemException;
/**
 * Class to extend in order to develop a customized Local Configuration Datastore. The Lcd is used by the <CODE>SnmpEngine</CODE> to store and retrieve data.
 *<P> <CODE>SnmpLcd</CODE> manages the Lcds needed by every {@link com.sun.jmx.snmp.internal.SnmpModel SnmpModel}. It is possible to add and remove {@link com.sun.jmx.snmp.internal.SnmpModelLcd SnmpModelLcd}.</P>
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 * @since 1.5
 */
public abstract class SnmpLcd {

    class SubSysLcdManager {
        private Hashtable<Integer, SnmpModelLcd> models =
                new Hashtable<Integer, SnmpModelLcd>();

        public void addModelLcd(int id,
                                SnmpModelLcd usmlcd) {
            models.put(new Integer(id), usmlcd);
        }

        public SnmpModelLcd getModelLcd(int id) {
            return models.get(new Integer(id));
        }

        public SnmpModelLcd removeModelLcd(int id) {
            return models.remove(new Integer(id));
        }
    }


    private Hashtable<SnmpSubSystem, SubSysLcdManager> subs =
            new Hashtable<SnmpSubSystem, SubSysLcdManager>();

    /**
     * Returns the number of time the engine rebooted.
     * @return The number of reboots or -1 if the information is not present in the Lcd.
     */
    public abstract int getEngineBoots();
    /**
     * Returns the engine Id located in the Lcd.
     * @return The engine Id or null if the information is not present in the Lcd.
     */
    public abstract String getEngineId();

    /**
     * Persists the number of reboots.
     * @param i Reboot number.
     */
    public abstract void storeEngineBoots(int i);

    /**
     * Persists the engine Id.
     * @param id The engine Id.
     */
    public abstract void  storeEngineId(SnmpEngineId id);
    /**
     * Adds an Lcd model.
     * @param sys The subsytem managing the model.
     * @param id The model Id.
     * @param lcd The Lcd model.
     */
    public void addModelLcd(SnmpSubSystem sys,
                            int id,
                            SnmpModelLcd lcd) {

        SubSysLcdManager subsys = subs.get(sys);
        if( subsys == null ) {
            subsys = new SubSysLcdManager();
            subs.put(sys, subsys);
        }

        subsys.addModelLcd(id, lcd);
    }
     /**
     * Removes an Lcd model.
     * @param sys The subsytem managing the model.
     * @param id The model Id.
     */
    public void removeModelLcd(SnmpSubSystem sys,
                                int id)
        throws SnmpUnknownModelLcdException, SnmpUnknownSubSystemException {

        SubSysLcdManager subsys = subs.get(sys);
        if( subsys != null ) {
            SnmpModelLcd lcd = subsys.removeModelLcd(id);
            if(lcd == null) {
                throw new SnmpUnknownModelLcdException("Model : " + id);
            }
        }
        else
            throw new SnmpUnknownSubSystemException(sys.toString());
    }

    /**
     * Gets an Lcd model.
     * @param sys The subsytem managing the model
     * @param id The model Id.
     * @return The Lcd model or null if no Lcd model were found.
     */
    public SnmpModelLcd getModelLcd(SnmpSubSystem sys,
                                    int id) {
        SubSysLcdManager subsys = subs.get(sys);

        if(subsys == null) return null;

        return subsys.getModelLcd(id);
    }
}
