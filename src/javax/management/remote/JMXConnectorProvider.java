/*
 * Copyright (c) 2002, 2013, Oracle and/or its affiliates. All rights reserved.
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


package javax.management.remote;

import java.io.IOException;
import java.util.Map;

/**
 * <p>A provider for creating JMX API connector clients using a given
 * protocol.  Instances of this interface are created by {@link
 * JMXConnectorFactory} as part of its {@link
 * JMXConnectorFactory#newJMXConnector(JMXServiceURL, Map)
 * newJMXConnector} method.</p>
 *
 * @since 1.5
 */
public interface JMXConnectorProvider {
    /**
     * <p>Creates a new connector client that is ready to connect
     * to the connector server at the given address.  Each successful
     * call to this method produces a different
     * <code>JMXConnector</code> object.</p>
     *
     * @param serviceURL the address of the connector server to connect to.
     *
     * @param environment a read-only Map containing named attributes
     * to determine how the connection is made.  Keys in this map must
     * be Strings.  The appropriate type of each associated value
     * depends on the attribute.
     *
     * @return a <code>JMXConnector</code> representing the new
     * connector client.  Each successful call to this method produces
     * a different object.
     *
     * @exception NullPointerException if <code>serviceURL</code> or
     * <code>environment</code> is null.
     *
     * @exception IOException It is recommended for a provider
     * implementation to throw {@code MalformedURLException} if the
     * protocol in the {@code serviceURL} is not recognized by this
     * provider, {@code JMXProviderException} if this is a provider
     * for the protocol in {@code serviceURL} but it cannot be used
     * for some reason or any other {@code IOException} if the
     * connection cannot be made because of a communication problem.
     */
    public JMXConnector newJMXConnector(JMXServiceURL serviceURL,
                                        Map<String,?> environment)
            throws IOException;
}
