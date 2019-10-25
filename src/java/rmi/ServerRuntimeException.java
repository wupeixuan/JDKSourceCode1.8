/*
 * Copyright (c) 1996, 2004, Oracle and/or its affiliates. All rights reserved.
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

package java.rmi;

/**
 * From a server executing on JDK&nbsp;1.1, a
 * <code>ServerRuntimeException</code> is thrown as a result of a
 * remote method invocation when a <code>RuntimeException</code> is
 * thrown while processing the invocation on the server, either while
 * unmarshalling the arguments, executing the remote method itself, or
 * marshalling the return value.
 *
 * A <code>ServerRuntimeException</code> instance contains the original
 * <code>RuntimeException</code> that occurred as its cause.
 *
 * <p>A <code>ServerRuntimeException</code> is not thrown from servers
 * executing on the Java 2 platform v1.2 or later versions.
 *
 * @author  Ann Wollrath
 * @since   JDK1.1
 * @deprecated no replacement
 */
@Deprecated
public class ServerRuntimeException extends RemoteException {

    /* indicate compatibility with JDK 1.1.x version of class */
    private static final long serialVersionUID = 7054464920481467219L;

    /**
     * Constructs a <code>ServerRuntimeException</code> with the specified
     * detail message and nested exception.
     *
     * @param s the detail message
     * @param ex the nested exception
     * @deprecated no replacement
     * @since JDK1.1
     */
    @Deprecated
    public ServerRuntimeException(String s, Exception ex) {
        super(s, ex);
    }
}
