/*
 *
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.jmx.snmp;

import java.security.BasicPermission;

/**
 * SNMP Permission
 *
 * <p><b>This API is a JDK internal API  and is subject
 * to change without notice.</b></p>
 */

public class SnmpPermission extends BasicPermission {
    /**
     * Constructs a SnmpPermission with the specified name.
     *
     * @param name Permission name.
     */
    public SnmpPermission(String name) {
        super(name);
    }

    /**
     * Constructs a new SnmpPermission object.
     *
     * @param name Permission name.
     * @param actions
     */
    public SnmpPermission(String name, String actions) {
        super(name, actions);
    }

}
