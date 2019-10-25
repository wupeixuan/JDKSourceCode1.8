/*
 * Copyright (c) 2003, 2004, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.spi.logging ;

import java.util.logging.Level ;
import java.util.logging.Logger ;
import java.util.logging.LogRecord ;

public abstract class LogWrapperBase {
    protected Logger logger ;

    protected String loggerName ;

    protected LogWrapperBase( Logger logger )
    {
        this.logger = logger ;
        this.loggerName = logger.getName( );
    }

    protected void doLog( Level level, String key, Object[] params, Class wrapperClass,
        Throwable thr )
    {
        LogRecord lrec = new LogRecord( level, key ) ;
        if (params != null)
            lrec.setParameters( params ) ;
        inferCaller( wrapperClass, lrec ) ;
        lrec.setThrown( thr ) ;
        lrec.setLoggerName( loggerName );
        lrec.setResourceBundle( logger.getResourceBundle() ) ;
        logger.log( lrec ) ;
    }

    private void inferCaller( Class wrapperClass, LogRecord lrec )
    {
        // Private method to infer the caller's class and method names

        // Get the stack trace.
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        StackTraceElement frame = null ;
        String wcname = wrapperClass.getName() ;
        String baseName = LogWrapperBase.class.getName() ;

        // The top of the stack should always be a method in the wrapper class,
        // or in this base class.
        // Search back to the first method not in the wrapper class or this class.
        int ix = 0;
        while (ix < stack.length) {
            frame = stack[ix];
            String cname = frame.getClassName();
            if (!cname.equals(wcname) && !cname.equals(baseName))  {
                break;
            }

            ix++;
        }

        // Set the class and method if we are not past the end of the stack
        // trace
        if (ix < stack.length) {
            lrec.setSourceClassName(frame.getClassName());
            lrec.setSourceMethodName(frame.getMethodName());
        }
    }

    protected void doLog( Level level, String key, Class wrapperClass, Throwable thr )
    {
        doLog( level, key, null, wrapperClass, thr ) ;
    }
}
