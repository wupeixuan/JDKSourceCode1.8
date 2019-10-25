/*
 * Copyright (c) 2008, 2011, Oracle and/or its affiliates. All rights reserved.
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

package java.lang;

/**
 * Thrown to indicate that an {@code invokedynamic} instruction has
 * failed to find its bootstrap method,
 * or the bootstrap method has failed to provide a
 * {@linkplain java.lang.invoke.CallSite call site} with a {@linkplain java.lang.invoke.CallSite#getTarget target}
 * of the correct {@linkplain java.lang.invoke.MethodHandle#type method type}.
 *
 * @author John Rose, JSR 292 EG
 * @since 1.7
 */
public class BootstrapMethodError extends LinkageError {
    private static final long serialVersionUID = 292L;

    /**
     * Constructs a {@code BootstrapMethodError} with no detail message.
     */
    public BootstrapMethodError() {
        super();
    }

    /**
     * Constructs a {@code BootstrapMethodError} with the specified
     * detail message.
     *
     * @param s the detail message.
     */
    public BootstrapMethodError(String s) {
        super(s);
    }

    /**
     * Constructs a {@code BootstrapMethodError} with the specified
     * detail message and cause.
     *
     * @param s the detail message.
     * @param cause the cause, may be {@code null}.
     */
    public BootstrapMethodError(String s, Throwable cause) {
        super(s, cause);
    }

    /**
     * Constructs a {@code BootstrapMethodError} with the specified
     * cause.
     *
     * @param cause the cause, may be {@code null}.
     */
    public BootstrapMethodError(Throwable cause) {
        // cf. Throwable(Throwable cause) constructor.
        super(cause == null ? null : cause.toString());
        initCause(cause);
    }
}
