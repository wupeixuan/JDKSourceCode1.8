/*
 * Copyright (c) 2002, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.orbutil;
/**
 * All the Keywords that will be used in Logging Messages for CORBA need to
 * be defined here. The LogKeywords will be useful for searching log messages
 * based on the standard keywords, it is also useful to work with LogAnalyzing
 * tools.
 * We will try to standardize these keywords in JSR 117 Logging
 */
public class LogKeywords {

    /**
     ** Keywords for Lifecycle Loggers.
     ** _REVISIT_ After it is clearly defined in JSR 117
     **/
    public final static String LIFECYCLE_CREATE     = "<<LIFECYCLE CREATE>>";
    public final static String LIFECYCLE_INITIALIZE = "<<LIFECYCLE INITIALIZE>>";
    public final static String LIFECYCLE_SHUTDOWN   = "<<LIFECYCLE SHUTDOWN>>";
    public final static String LIFECYCLE_DESTROY    = "<<LIFECYCLE DESTROY>>";


    public final static String LIFECYCLE_CREATE_SUCCESS =
        LIFECYCLE_CREATE + "<<SUCCESS>>";
    public final static String LIFECYCLE_CREATE_FAILURE =
        LIFECYCLE_CREATE + "<<FAILURE>>";
    public final static String LIFECYCLE_INITIALIZE_SUCCESS =
        LIFECYCLE_INITIALIZE + "<<SUCCESS>>";
    public final static String LIFECYCLE_INITIALIZE_FAILURE =
        LIFECYCLE_INITIALIZE + "<<FAILURE>>";
    public final static String LIFECYCLE_SHUTDOWN_SUCCESS =
        LIFECYCLE_SHUTDOWN + "<<SUCCESS>>";
    public final static String LIFECYCLE_SHUTDOWN_FAILURE =
        LIFECYCLE_SHUTDOWN + "<<FAILURE>>";
    public final static String LIFECYCLE_DESTROY_SUCCESS =
        LIFECYCLE_DESTROY + "<<SUCCESS>>";
    public final static String LIFECYCLE_DESTROY_FAILURE =
        LIFECYCLE_DESTROY + "<<FAILURE>>";

    /**
     ** Keywords for Naming Read Loggers.
     **/
    public final static String NAMING_RESOLVE       = "<<NAMING RESOLVE>>";
    public final static String NAMING_LIST          = "<<NAMING LIST>>";

    public final static String NAMING_RESOLVE_SUCCESS =
        NAMING_RESOLVE + "<<SUCCESS>>";
    public final static String NAMING_RESOLVE_FAILURE =
        NAMING_RESOLVE + "<<FAILURE>>";
    public final static String NAMING_LIST_SUCCESS =
        NAMING_LIST + "<<SUCCESS>>";
    public final static String NAMING_LIST_FAILURE =
        NAMING_LIST + "<<FAILURE>>";

    /**
     ** Keywords for Naming Update Loggers.
     **/
    public final static String NAMING_BIND          = "<<NAMING BIND>>";
    public final static String NAMING_UNBIND        = "<<NAMING UNBIND>>";
    public final static String NAMING_REBIND        = "<<NAMING REBIND>>";

    public final static String NAMING_BIND_SUCCESS =
        NAMING_BIND + "<<SUCCESS>>";
    public final static String NAMING_BIND_FAILURE =
        NAMING_BIND + "<<FAILURE>>";
    public final static String NAMING_UNBIND_SUCCESS =
        NAMING_UNBIND + "<<SUCCESS>>";
    public final static String NAMING_UNBIND_FAILURE =
        NAMING_UNBIND + "<<FAILURE>>";
    public final static String NAMING_REBIND_SUCCESS =
        NAMING_REBIND + "<<SUCCESS>>";
    public final static String NAMING_REBIND_FAILURE =
        NAMING_REBIND + "<<FAILURE>>";
}
