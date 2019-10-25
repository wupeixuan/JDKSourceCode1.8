/*
 * Copyright (c) 1997, 1999, Oracle and/or its affiliates. All rights reserved.
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

package java.rmi.activation;

/**
 * An <code>UnknownObjectException</code> is thrown by methods of classes and
 * interfaces in the <code>java.rmi.activation</code> package when the
 * <code>ActivationID</code> parameter to the method is determined to be
 * invalid.  An <code>ActivationID</code> is invalid if it is not currently
 * known by the <code>ActivationSystem</code>.  An <code>ActivationID</code>
 * is obtained by the <code>ActivationSystem.registerObject</code> method.
 * An <code>ActivationID</code> is also obtained during the
 * <code>Activatable.register</code> call.
 *
 * @author  Ann Wollrath
 * @since   1.2
 * @see     java.rmi.activation.Activatable
 * @see     java.rmi.activation.ActivationGroup
 * @see     java.rmi.activation.ActivationID
 * @see     java.rmi.activation.ActivationMonitor
 * @see     java.rmi.activation.ActivationSystem
 * @see     java.rmi.activation.Activator
 */
public class UnknownObjectException extends ActivationException {

    /** indicate compatibility with the Java 2 SDK v1.2 version of class */
    private static final long serialVersionUID = 3425547551622251430L;

    /**
     * Constructs an <code>UnknownObjectException</code> with the specified
     * detail message.
     *
     * @param s the detail message
     * @since 1.2
     */
    public UnknownObjectException(String s) {
        super(s);
    }
}
