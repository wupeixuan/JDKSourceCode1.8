/*
 * Copyright (c) 2002, 2012, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package sun.security.ssl;

import java.io.*;
import java.nio.channels.SocketChannel;
import java.net.*;

import javax.net.ssl.*;

/**
 * Abstract base class for SSLSocketImpl. Its purpose is to house code with
 * no SSL related logic (or no logic at all). This makes SSLSocketImpl shorter
 * and easier to read. It contains a few constants and static methods plus
 * overridden java.net.Socket methods.
 *
 * Methods are defined final to ensure that they are not accidentally
 * overridden in SSLSocketImpl.
 *
 * @see javax.net.ssl.SSLSocket
 * @see SSLSocketImpl
 *
 */
abstract class BaseSSLSocketImpl extends SSLSocket {

    /*
     * Normally "self" is "this" ... but not when this connection is
     * layered over a preexisting socket.  If we're using an existing
     * socket, we delegate some actions to it.  Else, we delegate
     * instead to "super".  This is important to ensure that we don't
     * recurse infinitely ... e.g. close() calling itself, or doing
     * I/O in terms of our own streams.
     */
    final private Socket self;
    final private InputStream consumedInput;

    BaseSSLSocketImpl() {
        super();
        this.self = this;
        this.consumedInput = null;
    }

    BaseSSLSocketImpl(Socket socket) {
        super();
        this.self = socket;
        this.consumedInput = null;
    }

    BaseSSLSocketImpl(Socket socket, InputStream consumed) {
        super();
        this.self = socket;
        this.consumedInput = consumed;
    }

    //
    // CONSTANTS AND STATIC METHODS
    //

    /**
     * TLS requires that a close_notify warning alert is sent before the
     * connection is closed in order to avoid truncation attacks. Some
     * implementations (MS IIS and others) don't do that. The property
     * below controls whether we accept that or treat it as an error.
     *
     * The default is "false", i.e. tolerate the broken behavior.
     */
    private final static String PROP_NAME =
                                "com.sun.net.ssl.requireCloseNotify";

    final static boolean requireCloseNotify =
                                Debug.getBooleanProperty(PROP_NAME, false);

    //
    // MISC SOCKET METHODS
    //

    /**
     * Returns the unique {@link java.nio.SocketChannel SocketChannel} object
     * associated with this socket, if any.
     * @see Socket#getChannel
     */
    @Override
    public final SocketChannel getChannel() {
        if (self == this) {
            return super.getChannel();
        } else {
            return self.getChannel();
        }
    }

    /**
     * Binds the address to the socket.
     * @see Socket#bind
     */
    @Override
    public void bind(SocketAddress bindpoint) throws IOException {
        /*
         * Bind to this socket
         */
        if (self == this) {
            super.bind(bindpoint);
        } else {
            // If we're binding on a layered socket...
            throw new IOException(
                "Underlying socket should already be connected");
        }
    }

    /**
     * Returns the address of the endpoint this socket is connected to
     * @see Socket#getLocalSocketAddress
     */
    @Override
    public SocketAddress getLocalSocketAddress() {
        if (self == this) {
            return super.getLocalSocketAddress();
        } else {
            return self.getLocalSocketAddress();
        }
    }

    /**
     * Returns the address of the endpoint this socket is connected to
     * @see Socket#getRemoteSocketAddress
     */
    @Override
    public SocketAddress getRemoteSocketAddress() {
        if (self == this) {
            return super.getRemoteSocketAddress();
        } else {
            return self.getRemoteSocketAddress();
        }
    }

    /**
     * Connects this socket to the server.
     *
     * This method is either called on an unconnected SSLSocketImpl by the
     * application, or it is called in the constructor of a regular
     * SSLSocketImpl. If we are layering on top on another socket, then
     * this method should not be called, because we assume that the
     * underlying socket is already connected by the time it is passed to
     * us.
     *
     * @param   endpoint the <code>SocketAddress</code>
     * @throws  IOException if an error occurs during the connection
     */
    @Override
    public final void connect(SocketAddress endpoint) throws IOException {
        connect(endpoint, 0);
    }

    /**
     * Returns the connection state of the socket.
     * @see Socket#isConnected
     */
    @Override
    public final boolean isConnected() {
        if (self == this) {
            return super.isConnected();
        } else {
            return self.isConnected();
        }
    }

    /**
     * Returns the binding state of the socket.
     * @see Socket#isBound
     */
    @Override
    public final boolean isBound() {
        if (self == this) {
            return super.isBound();
        } else {
            return self.isBound();
        }
    }

    //
    // CLOSE RELATED METHODS
    //

    /**
     * The semantics of shutdownInput is not supported in TLS 1.0
     * spec. Thus when the method is called on an SSL socket, an
     * UnsupportedOperationException will be thrown.
     *
     * @throws UnsupportedOperationException
     */
    @Override
    public final void shutdownInput() throws IOException {
        throw new UnsupportedOperationException("The method shutdownInput()" +
                   " is not supported in SSLSocket");
    }

    /**
     * The semantics of shutdownOutput is not supported in TLS 1.0
     * spec. Thus when the method is called on an SSL socket, an
     * UnsupportedOperationException will be thrown.
     *
     * @throws UnsupportedOperationException
     */
    @Override
    public final void shutdownOutput() throws IOException {
        throw new UnsupportedOperationException("The method shutdownOutput()" +
                   " is not supported in SSLSocket");

    }

    /**
     * Returns the input state of the socket
     * @see Socket#isInputShutdown
     */
    @Override
    public final boolean isInputShutdown() {
        if (self == this) {
            return super.isInputShutdown();
        } else {
            return self.isInputShutdown();
        }
    }

    /**
     * Returns the output state of the socket
     * @see Socket#isOutputShutdown
     */
    @Override
    public final boolean isOutputShutdown() {
        if (self == this) {
            return super.isOutputShutdown();
        } else {
            return self.isOutputShutdown();
        }
    }

    /**
     * Ensures that the SSL connection is closed down as cleanly
     * as possible, in case the application forgets to do so.
     * This allows SSL connections to be implicitly reclaimed,
     * rather than forcing them to be explicitly reclaimed at
     * the penalty of prematurly killing SSL sessions.
     */
    @Override
    protected final void finalize() throws Throwable {
        try {
            close();
        } catch (IOException e1) {
            try {
                if (self == this) {
                    super.close();
                }
            } catch (IOException e2) {
                // ignore
            }
        } finally {
            // We called close on the underlying socket above to
            // make doubly sure all resources got released.  We
            // don't finalize self in the case of overlain sockets,
            // that's a different object which the GC will finalize
            // separately.

            super.finalize();
        }
    }

    //
    // GET ADDRESS METHODS
    //

    /**
     * Returns the address of the remote peer for this connection.
     */
    @Override
    public final InetAddress getInetAddress() {
        if (self == this) {
            return super.getInetAddress();
        } else {
            return self.getInetAddress();
        }
    }

    /**
     * Gets the local address to which the socket is bound.
     *
     * @return the local address to which the socket is bound.
     * @since   JDK1.1
     */
    @Override
    public final InetAddress getLocalAddress() {
        if (self == this) {
            return super.getLocalAddress();
        } else {
            return self.getLocalAddress();
        }
    }

    /**
     * Returns the number of the remote port that this connection uses.
     */
    @Override
    public final int getPort() {
        if (self == this) {
            return super.getPort();
        } else {
            return self.getPort();
        }
    }

    /**
     * Returns the number of the local port that this connection uses.
     */
    @Override
    public final int getLocalPort() {
        if (self == this) {
            return super.getLocalPort();
        } else {
            return self.getLocalPort();
        }
    }

    //
    // SOCKET OPTION METHODS
    //

    /**
     * Enables or disables the Nagle optimization.
     * @see Socket#setTcpNoDelay
     */
    @Override
    public final void setTcpNoDelay(boolean value) throws SocketException {
        if (self == this) {
            super.setTcpNoDelay(value);
        } else {
            self.setTcpNoDelay(value);
        }
    }

    /**
     * Returns true if the Nagle optimization is disabled.  This
     * relates to low-level buffering of TCP traffic, delaying the
     * traffic to promote better throughput.
     *
     * @see Socket#getTcpNoDelay
     */
    @Override
    public final boolean getTcpNoDelay() throws SocketException {
        if (self == this) {
            return super.getTcpNoDelay();
        } else {
            return self.getTcpNoDelay();
        }
    }

    /**
     * Assigns the socket's linger timeout.
     * @see Socket#setSoLinger
     */
    @Override
    public final void setSoLinger(boolean flag, int linger)
            throws SocketException {
        if (self == this) {
            super.setSoLinger(flag, linger);
        } else {
            self.setSoLinger(flag, linger);
        }
    }

    /**
     * Returns the socket's linger timeout.
     * @see Socket#getSoLinger
     */
    @Override
    public final int getSoLinger() throws SocketException {
        if (self == this) {
            return super.getSoLinger();
        } else {
            return self.getSoLinger();
        }
    }

    /**
     * Send one byte of urgent data on the socket.
     * @see Socket#sendUrgentData
     * At this point, there seems to be no specific requirement to support
     * this for an SSLSocket. An implementation can be provided if a need
     * arises in future.
     */
    @Override
    public final void sendUrgentData(int data) throws SocketException {
        throw new SocketException("This method is not supported "
                        + "by SSLSockets");
    }

    /**
     * Enable/disable OOBINLINE (receipt of TCP urgent data) By default, this
     * option is disabled and TCP urgent data received on a socket is silently
     * discarded.
     * @see Socket#setOOBInline
     * Setting OOBInline does not have any effect on SSLSocket,
     * since currently we don't support sending urgent data.
     */
    @Override
    public final void setOOBInline(boolean on) throws SocketException {
        throw new SocketException("This method is ineffective, since"
                + " sending urgent data is not supported by SSLSockets");
    }

    /**
     * Tests if OOBINLINE is enabled.
     * @see Socket#getOOBInline
     */
    @Override
    public final boolean getOOBInline() throws SocketException {
        throw new SocketException("This method is ineffective, since"
                + " sending urgent data is not supported by SSLSockets");
    }

    /**
     * Returns the socket timeout.
     * @see Socket#getSoTimeout
     */
    @Override
    public final int getSoTimeout() throws SocketException {
        if (self == this) {
            return super.getSoTimeout();
        } else {
            return self.getSoTimeout();
        }
    }

    @Override
    public final void setSendBufferSize(int size) throws SocketException {
        if (self == this) {
            super.setSendBufferSize(size);
        } else {
            self.setSendBufferSize(size);
        }
    }

    @Override
    public final int getSendBufferSize() throws SocketException {
        if (self == this) {
            return super.getSendBufferSize();
        } else {
            return self.getSendBufferSize();
        }
    }

    @Override
    public final void setReceiveBufferSize(int size) throws SocketException {
        if (self == this) {
            super.setReceiveBufferSize(size);
        } else {
            self.setReceiveBufferSize(size);
        }
    }

    @Override
    public final int getReceiveBufferSize() throws SocketException {
        if (self == this) {
            return super.getReceiveBufferSize();
        } else {
            return self.getReceiveBufferSize();
        }
    }

    /**
     * Enable/disable SO_KEEPALIVE.
     * @see Socket#setKeepAlive
     */
    @Override
    public final void setKeepAlive(boolean on) throws SocketException {
        if (self == this) {
            super.setKeepAlive(on);
        } else {
            self.setKeepAlive(on);
        }
    }

    /**
     * Tests if SO_KEEPALIVE is enabled.
     * @see Socket#getKeepAlive
     */
    @Override
    public final boolean getKeepAlive() throws SocketException {
        if (self == this) {
            return super.getKeepAlive();
        } else {
            return self.getKeepAlive();
        }
    }

    /**
     * Sets traffic class or type-of-service octet in the IP header for
     * packets sent from this Socket.
     * @see Socket#setTrafficClass
     */
    @Override
    public final void setTrafficClass(int tc) throws SocketException {
        if (self == this) {
            super.setTrafficClass(tc);
        } else {
            self.setTrafficClass(tc);
        }
    }

    /**
     * Gets traffic class or type-of-service in the IP header for packets
     * sent from this Socket.
     * @see Socket#getTrafficClass
     */
    @Override
    public final int getTrafficClass() throws SocketException {
        if (self == this) {
            return super.getTrafficClass();
        } else {
            return self.getTrafficClass();
        }
    }

    /**
     * Enable/disable SO_REUSEADDR.
     * @see Socket#setReuseAddress
     */
    @Override
    public final void setReuseAddress(boolean on) throws SocketException {
        if (self == this) {
            super.setReuseAddress(on);
        } else {
            self.setReuseAddress(on);
        }
    }

    /**
     * Tests if SO_REUSEADDR is enabled.
     * @see Socket#getReuseAddress
     */
    @Override
    public final boolean getReuseAddress() throws SocketException {
        if (self == this) {
            return super.getReuseAddress();
        } else {
            return self.getReuseAddress();
        }
    }

    /**
     * Sets performance preferences for this socket.
     *
     * @see Socket#setPerformancePreferences(int, int, int)
     */
    @Override
    public void setPerformancePreferences(int connectionTime,
            int latency, int bandwidth) {
        if (self == this) {
            super.setPerformancePreferences(
                connectionTime, latency, bandwidth);
        } else {
            self.setPerformancePreferences(
                connectionTime, latency, bandwidth);
        }
    }

    @Override
    public String toString() {
        if (self == this) {
            return super.toString();
        }

        return self.toString();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        if (self == this) {
            return super.getInputStream();
        }

        if (consumedInput != null) {
            return new SequenceInputStream(consumedInput,
                                                self.getInputStream());
        }

        return self.getInputStream();
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        if (self == this) {
            return super.getOutputStream();
        }

        return self.getOutputStream();
    }

    @Override
    public synchronized void close() throws IOException {
        if (self == this) {
            super.close();
        } else {
            self.close();
        }
    }

    @Override
    public synchronized void setSoTimeout(int timeout) throws SocketException {
        if (self == this) {
            super.setSoTimeout(timeout);
        } else {
            self.setSoTimeout(timeout);
        }
    }

    boolean isLayered() {
        return (self != this);
    }
}
