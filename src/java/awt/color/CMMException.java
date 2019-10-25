/*
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

/*
    Created by gbp, October 25, 1997

 *
 */
/*
 **********************************************************************
 **********************************************************************
 **********************************************************************
 *** COPYRIGHT (c) Eastman Kodak Company, 1997                      ***
 *** As  an unpublished  work pursuant to Title 17 of the United    ***
 *** States Code.  All rights reserved.                             ***
 **********************************************************************
 **********************************************************************
 **********************************************************************/


package java.awt.color;


/**
 * This exception is thrown if the native CMM returns an error.
 */

public class CMMException extends java.lang.RuntimeException {

    /**
     *  Constructs a CMMException with the specified detail message.
     *  @param s the specified detail message
     */
    public CMMException (String s) {
        super (s);
    }
}
