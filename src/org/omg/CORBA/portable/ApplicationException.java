/*
 * Copyright (c) 1998, 1999, Oracle and/or its affiliates. All rights reserved.
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

package org.omg.CORBA.portable;

/**
This class is used for reporting application level exceptions between ORBs and stubs.
*/

public class ApplicationException extends Exception {
    /**
     * Constructs an ApplicationException from the CORBA repository ID of the exception
     * and an input stream from which the exception data can be read as its parameters.
     * @param id the repository id of the user exception
     * @param ins the stream which contains the user exception data
     */
    public ApplicationException(String id,
                                InputStream ins) {
        this.id = id;
        this.ins = ins;
    }

    /**
     * Returns the CORBA repository ID of the exception
     * without removing it from the exceptions input stream.
     * @return The CORBA repository ID of this exception
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the input stream from which the exception data can be read as its parameters.
     * @return The stream which contains the user exception data
     */
    public InputStream getInputStream() {
        return ins;
    }

    private String id;
    private InputStream ins;
}
