/*
 * Copyright (c) 2002, 2005, Oracle and/or its affiliates. All rights reserved.
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

package java.net;
import java.io.IOException;
/*
 * Package private interface to "implementation" used by
 * {@link InetAddress}.
 * <p>
 * See {@link java.net.Inet4AddressImp} and
 * {@link java.net.Inet6AddressImp}.
 *
 * @since 1.4
 */
interface InetAddressImpl {

    String getLocalHostName() throws UnknownHostException;
    InetAddress[]
        lookupAllHostAddr(String hostname) throws UnknownHostException;
    String getHostByAddr(byte[] addr) throws UnknownHostException;

    InetAddress anyLocalAddress();
    InetAddress loopbackAddress();
    boolean isReachable(InetAddress addr, int timeout, NetworkInterface netif,
                        int ttl) throws IOException;
}
