/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jmx.snmp.agent;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.Vector;

import javax.management.ObjectName;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.NotCompliantMBeanException;

import static com.sun.jmx.defaults.JmxProperties.SNMP_ADAPTOR_LOGGER;
import com.sun.jmx.snmp.SnmpOid;
import com.sun.jmx.snmp.SnmpVarBind;
import com.sun.jmx.snmp.SnmpDefinitions;
import com.sun.jmx.snmp.SnmpStatusException;
import com.sun.jmx.snmp.SnmpEngine;
import com.sun.jmx.snmp.SnmpUnknownModelException;
import com.sun.jmx.snmp.internal.SnmpAccessControlModel;
import com.sun.jmx.snmp.internal.SnmpEngineImpl;

/**
 * Oid Checker makes use of ACM to check each OID during the getnext process.
 */
class AcmChecker {


    SnmpAccessControlModel model = null;
    String principal = null;
    int securityLevel = -1;
    int version = -1;
    int pduType = -1;
    int securityModel = -1;
    byte[] contextName = null;
    SnmpEngineImpl engine = null;
    LongList l = null;
    AcmChecker(SnmpMibRequest req) {
        engine = (SnmpEngineImpl) req.getEngine();
        //We are in V3 architecture, ACM is in the picture.
        if(engine != null) {
            if(engine.isCheckOidActivated()) {
                try {
                    if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                        SNMP_ADAPTOR_LOGGER.logp(Level.FINEST,
                                SnmpMib.class.getName(),
                                "AcmChecker(SnmpMibRequest)",
                                "SNMP V3 Access Control to be done");
                    }
                    model = (SnmpAccessControlModel)
                        engine.getAccessControlSubSystem().
                        getModel(SnmpDefinitions.snmpVersionThree);
                    principal = req.getPrincipal();
                    securityLevel = req.getSecurityLevel();
                    pduType = req.getPdu().type;
                    version = req.getRequestPduVersion();
                    securityModel = req.getSecurityModel();
                    contextName = req.getAccessContextName();
                    l = new LongList();
                    if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                        final StringBuilder strb = new StringBuilder()
                        .append("Will check oid for : principal : ")
                        .append(principal)
                        .append("; securityLevel : ").append(securityLevel)
                        .append("; pduType : ").append(pduType)
                        .append("; version : ").append(version)
                        .append("; securityModel : ").append(securityModel)
                        .append("; contextName : ").append(contextName);
                        SNMP_ADAPTOR_LOGGER.logp(Level.FINEST,
                                SnmpMib.class.getName(),
                                "AcmChecker(SnmpMibRequest)", strb.toString());
                    }

                }catch(SnmpUnknownModelException e) {
                    if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                        SNMP_ADAPTOR_LOGGER.logp(Level.FINEST,
                                SnmpMib.class.getName(),
                                "AcmChecker(SnmpMibRequest)",
                                "Unknown Model, no ACM check.");
                    }
                }
            }
        }
    }

    void add(int index, long arc) {
        if(model != null)
            l.add(index, arc);
    }

    void remove(int index) {
        if(model != null)
            l.remove(index);
    }

    void add(final int at,final long[] src, final int from,
             final int count) {
        if(model != null)
            l.add(at,src,from,count);
    }

    void remove(final int from, final int count) {
        if(model != null)
            l.remove(from,count);
    }

    void checkCurrentOid() throws SnmpStatusException {
        if(model != null) {
            SnmpOid oid = new SnmpOid(l.toArray());
            if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpMib.class.getName(),
                        "checkCurrentOid", "Checking access for : " + oid);
            }
            model.checkAccess(version,
                              principal,
                              securityLevel,
                              pduType,
                              securityModel,
                              contextName,
                              oid);
        }
    }

}
