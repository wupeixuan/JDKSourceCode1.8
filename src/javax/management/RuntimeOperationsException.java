/*
 * Copyright (c) 1999, 2003, Oracle and/or its affiliates. All rights reserved.
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

package javax.management;



/**
 * Represents runtime exceptions thrown in the agent when performing operations on MBeans.
 * It wraps the actual <CODE>java.lang.RuntimeException</CODE> thrown.
 *
 * @since 1.5
 */
public class RuntimeOperationsException extends JMRuntimeException   {

    /* Serial version */
    private static final long serialVersionUID = -8408923047489133588L;

    /**
     * @serial The encapsulated {@link RuntimeException}
     */
    private java.lang.RuntimeException runtimeException ;


    /**
     * Creates a <CODE>RuntimeOperationsException</CODE> that wraps the actual <CODE>java.lang.RuntimeException</CODE>.
     *
     * @param e the wrapped exception.
     */
    public RuntimeOperationsException(java.lang.RuntimeException e) {
        super() ;
        runtimeException = e ;
    }

    /**
     * Creates a <CODE>RuntimeOperationsException</CODE> that wraps the actual <CODE>java.lang.RuntimeException</CODE>
     * with a detailed message.
     *
     * @param e the wrapped exception.
     * @param message the detail message.
     */
    public RuntimeOperationsException(java.lang.RuntimeException e, String message) {
        super(message);
        runtimeException = e ;
    }

    /**
     * Returns the actual {@link RuntimeException} thrown.
     *
     * @return the wrapped {@link RuntimeException}.
     */
    public java.lang.RuntimeException getTargetException()  {
        return runtimeException ;
    }

    /**
     * Returns the actual {@link RuntimeException} thrown.
     *
     * @return the wrapped {@link RuntimeException}.
     */
    public Throwable getCause() {
        return runtimeException;
    }
}
