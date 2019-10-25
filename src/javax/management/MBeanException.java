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
 * Represents "user defined" exceptions thrown by MBean methods
 * in the agent. It "wraps" the actual "user defined" exception thrown.
 * This exception will be built by the MBeanServer when a call to an
 * MBean method results in an unknown exception.
 *
 * @since 1.5
 */
public class MBeanException extends JMException   {


    /* Serial version */
    private static final long serialVersionUID = 4066342430588744142L;

    /**
     * @serial Encapsulated {@link Exception}
     */
    private java.lang.Exception exception ;


    /**
     * Creates an <CODE>MBeanException</CODE> that wraps the actual <CODE>java.lang.Exception</CODE>.
     *
     * @param e the wrapped exception.
     */
    public MBeanException(java.lang.Exception e) {
        super() ;
        exception = e ;
    }

    /**
     * Creates an <CODE>MBeanException</CODE> that wraps the actual <CODE>java.lang.Exception</CODE> with
     * a detail message.
     *
     * @param e the wrapped exception.
     * @param message the detail message.
     */
    public MBeanException(java.lang.Exception e, String message) {
        super(message) ;
        exception = e ;
    }


    /**
     * Return the actual {@link Exception} thrown.
     *
     * @return the wrapped exception.
     */
    public Exception getTargetException()  {
        return exception;
    }

    /**
     * Return the actual {@link Exception} thrown.
     *
     * @return the wrapped exception.
     */
    public Throwable getCause() {
        return exception;
    }
}
