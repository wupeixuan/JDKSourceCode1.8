/*
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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
package java.rmi.server;

/**
 * The {@code RemoteStub} class is the common superclass of
 * statically generated client
 * stubs and provides the framework to support a wide range of remote
 * reference semantics.  Stub objects are surrogates that support
 * exactly the same set of remote interfaces defined by the actual
 * implementation of the remote object.
 *
 * @author  Ann Wollrath
 * @since   JDK1.1
 *
 * @deprecated Statically generated stubs are deprecated, since
 * stubs are generated dynamically. See {@link UnicastRemoteObject}
 * for information about dynamic stub generation.
 */
@Deprecated
abstract public class RemoteStub extends RemoteObject {

    /** indicate compatibility with JDK 1.1.x version of class */
    private static final long serialVersionUID = -1585587260594494182L;

    /**
     * Constructs a {@code RemoteStub}.
     */
    protected RemoteStub() {
        super();
    }

    /**
     * Constructs a {@code RemoteStub} with the specified remote
     * reference.
     *
     * @param ref the remote reference
     * @since JDK1.1
     */
    protected RemoteStub(RemoteRef ref) {
        super(ref);
    }

    /**
     * Throws {@link UnsupportedOperationException}.
     *
     * @param stub the remote stub
     * @param ref the remote reference
     * @throws UnsupportedOperationException always
     * @since JDK1.1
     * @deprecated No replacement.  The {@code setRef} method
     * was intended for setting the remote reference of a remote
     * stub. This is unnecessary, since {@code RemoteStub}s can be created
     * and initialized with a remote reference through use of
     * the {@link #RemoteStub(RemoteRef)} constructor.
     */
    @Deprecated
    protected static void setRef(RemoteStub stub, RemoteRef ref) {
        throw new UnsupportedOperationException();
    }
}
