/*
 * Copyright (c) 2001, 2002, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.orbutil.concurrent;

import com.sun.corba.se.impl.orbutil.concurrent.Sync ;

public class SyncUtil {
    private SyncUtil() {}

    /** Method to acquire a Sync without ever throwing an
    * InterruptedException.  Useful when a mutex is being
    * used in place of Java synchronization.
    */
    public static void acquire( Sync sync )
    {
        boolean held = false ;
        while (!held) {
            try {
                sync.acquire() ;
                held = true ;
            } catch (InterruptedException exc) {
                held = false ;
            }
        }
    }
}
