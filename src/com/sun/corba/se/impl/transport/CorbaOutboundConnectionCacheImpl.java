/*
 * Copyright (c) 2003, 2004, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.transport;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

import com.sun.corba.se.pept.broker.Broker;
import com.sun.corba.se.pept.transport.ContactInfo;
import com.sun.corba.se.pept.transport.Connection;
import com.sun.corba.se.pept.transport.OutboundConnectionCache;

import com.sun.corba.se.spi.monitoring.LongMonitoredAttributeBase;
import com.sun.corba.se.spi.monitoring.MonitoringConstants;
import com.sun.corba.se.spi.monitoring.MonitoringFactories;
import com.sun.corba.se.spi.monitoring.MonitoredObject;
import com.sun.corba.se.spi.orb.ORB;
import com.sun.corba.se.spi.transport.CorbaConnectionCache;
import com.sun.corba.se.spi.transport.CorbaContactInfo;

import com.sun.corba.se.impl.orbutil.ORBUtility;

/**
 * @author Harold Carr
 */
public class CorbaOutboundConnectionCacheImpl
    extends
        CorbaConnectionCacheBase
    implements
        OutboundConnectionCache
{
    protected Hashtable connectionCache;

    public CorbaOutboundConnectionCacheImpl(ORB orb, ContactInfo contactInfo)
    {
        super(orb, contactInfo.getConnectionCacheType(),
              ((CorbaContactInfo)contactInfo).getMonitoringName());
        this.connectionCache = new Hashtable();
    }

    ////////////////////////////////////////////////////
    //
    // pept.transport.OutboundConnectionCache
    //

    public Connection get(ContactInfo contactInfo)
    {
        if (orb.transportDebugFlag) {
            dprint(".get: " + contactInfo + " " + contactInfo.hashCode());
        }
        synchronized (backingStore()) {
            dprintStatistics();
            return (Connection) connectionCache.get(contactInfo);
        }
    }

    public void put(ContactInfo contactInfo, Connection connection)
    {
        if (orb.transportDebugFlag) {
            dprint(".put: " + contactInfo + " " + contactInfo.hashCode() + " "
                   + connection);
        }
        synchronized (backingStore()) {
            connectionCache.put(contactInfo, connection);
            connection.setConnectionCache(this);
            dprintStatistics();
        }
    }

    public void remove(ContactInfo contactInfo)
    {
        if (orb.transportDebugFlag) {
            dprint(".remove: " + contactInfo + " " + contactInfo.hashCode());
        }
        synchronized (backingStore()) {
            if (contactInfo != null) {
                connectionCache.remove(contactInfo);
            }
            dprintStatistics();
        }
    }

    ////////////////////////////////////////////////////
    //
    // Implementation
    //

    public Collection values()
    {
        return connectionCache.values();
    }

    protected Object backingStore()
    {
        return connectionCache;
    }

    protected void registerWithMonitoring()
    {
        // ORB
        MonitoredObject orbMO =
            orb.getMonitoringManager().getRootMonitoredObject();

        // CONNECTION
        MonitoredObject connectionMO =
            orbMO.getChild(MonitoringConstants.CONNECTION_MONITORING_ROOT);
        if (connectionMO == null) {
            connectionMO =
                MonitoringFactories.getMonitoredObjectFactory()
                    .createMonitoredObject(
                        MonitoringConstants.CONNECTION_MONITORING_ROOT,
                        MonitoringConstants.CONNECTION_MONITORING_ROOT_DESCRIPTION);
            orbMO.addChild(connectionMO);
        }

        // OUTBOUND CONNECTION
        MonitoredObject outboundConnectionMO =
            connectionMO.getChild(
                MonitoringConstants.OUTBOUND_CONNECTION_MONITORING_ROOT);
        if (outboundConnectionMO == null) {
            outboundConnectionMO =
                MonitoringFactories.getMonitoredObjectFactory()
                    .createMonitoredObject(
                        MonitoringConstants.OUTBOUND_CONNECTION_MONITORING_ROOT,
                        MonitoringConstants.OUTBOUND_CONNECTION_MONITORING_ROOT_DESCRIPTION);
            connectionMO.addChild(outboundConnectionMO);
        }

        // NODE FOR THIS CACHE
        MonitoredObject thisMO =
            outboundConnectionMO.getChild(getMonitoringName());
        if (thisMO == null) {
            thisMO =
                MonitoringFactories.getMonitoredObjectFactory()
                    .createMonitoredObject(
                        getMonitoringName(),
                        MonitoringConstants.CONNECTION_MONITORING_DESCRIPTION);
            outboundConnectionMO.addChild(thisMO);
        }

        LongMonitoredAttributeBase attribute;

        // ATTRIBUTE
        attribute = new
            LongMonitoredAttributeBase(
                MonitoringConstants.CONNECTION_TOTAL_NUMBER_OF_CONNECTIONS,
                MonitoringConstants.CONNECTION_TOTAL_NUMBER_OF_CONNECTIONS_DESCRIPTION)
            {
                public Object getValue() {
                    return new Long(CorbaOutboundConnectionCacheImpl.this.numberOfConnections());
                }
            };
        thisMO.addAttribute(attribute);

        // ATTRIBUTE
        attribute = new
            LongMonitoredAttributeBase(
                MonitoringConstants.CONNECTION_NUMBER_OF_IDLE_CONNECTIONS,
                MonitoringConstants.CONNECTION_NUMBER_OF_IDLE_CONNECTIONS_DESCRIPTION)
            {
                public Object getValue() {
                    return new Long(CorbaOutboundConnectionCacheImpl.this.numberOfIdleConnections());
                }
            };
        thisMO.addAttribute(attribute);

        // ATTRIBUTE
        attribute = new
            LongMonitoredAttributeBase(
                MonitoringConstants.CONNECTION_NUMBER_OF_BUSY_CONNECTIONS,
                MonitoringConstants.CONNECTION_NUMBER_OF_BUSY_CONNECTIONS_DESCRIPTION)
            {
                public Object getValue() {
                    return new Long(CorbaOutboundConnectionCacheImpl.this.numberOfBusyConnections());
                }
            };
        thisMO.addAttribute(attribute);
    }

    protected void dprint(String msg)
    {
        ORBUtility.dprint("CorbaOutboundConnectionCacheImpl", msg);
    }
}

// End of file.
