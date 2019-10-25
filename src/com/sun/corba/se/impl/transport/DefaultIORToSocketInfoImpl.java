/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.omg.IOP.TAG_ALTERNATE_IIOP_ADDRESS ;

import com.sun.corba.se.spi.ior.IOR;
import com.sun.corba.se.spi.ior.ObjectKeyTemplate;
import com.sun.corba.se.spi.ior.iiop.IIOPProfile ;
import com.sun.corba.se.spi.ior.iiop.IIOPProfileTemplate ;
import com.sun.corba.se.spi.ior.iiop.IIOPAddress ;
import com.sun.corba.se.spi.ior.iiop.AlternateIIOPAddressComponent;
import com.sun.corba.se.spi.transport.IORToSocketInfo;
import com.sun.corba.se.spi.transport.SocketInfo;

public class DefaultIORToSocketInfoImpl
    implements IORToSocketInfo
{
    public List getSocketInfo(IOR ior)
    {
        SocketInfo socketInfo;
        List result = new ArrayList();

        IIOPProfileTemplate iiopProfileTemplate = (IIOPProfileTemplate)
            ior.getProfile().getTaggedProfileTemplate() ;
        IIOPAddress primary = iiopProfileTemplate.getPrimaryAddress() ;
        String hostname = primary.getHost().toLowerCase();
        int    port     = primary.getPort();
        // NOTE: we could check for 0 (i.e., CSIv2) but, for a
        // non-CSIv2-configured client ORB talking to a CSIv2 configured
        // server ORB you might end up with an empty contact info list
        // which would then report a failure which would not be as
        // instructive as leaving a ContactInfo with a 0 port in the list.
        socketInfo = createSocketInfo(hostname, port);
        result.add(socketInfo);

        Iterator iterator = iiopProfileTemplate.iteratorById(
            TAG_ALTERNATE_IIOP_ADDRESS.value);

        while (iterator.hasNext()) {
            AlternateIIOPAddressComponent alternate =
                (AlternateIIOPAddressComponent) iterator.next();
            hostname = alternate.getAddress().getHost().toLowerCase();
            port     = alternate.getAddress().getPort();
            socketInfo= createSocketInfo(hostname, port);
            result.add(socketInfo);
        }
        return result;
    }

    private SocketInfo createSocketInfo(final String hostname, final int port)
    {
        return new SocketInfo() {
            public String getType() { return SocketInfo.IIOP_CLEAR_TEXT; }
            public String getHost() { return hostname; }
            public int    getPort() { return port; }};
    }
}

// End of file.
