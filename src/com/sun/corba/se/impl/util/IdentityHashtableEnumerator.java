/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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
 * Licensed Materials - Property of IBM
 * RMI-IIOP v1.0
 * Copyright IBM Corp. 1998 1999  All Rights Reserved
 *
 */

package com.sun.corba.se.impl.util;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/**
 * A hashtable enumerator class.  This class should remain opaque
 * to the client. It will use the Enumeration interface.
 */
class IdentityHashtableEnumerator implements Enumeration {
    boolean keys;
    int index;
    IdentityHashtableEntry table[];
    IdentityHashtableEntry entry;

    IdentityHashtableEnumerator(IdentityHashtableEntry table[], boolean keys) {
        this.table = table;
        this.keys = keys;
        this.index = table.length;
    }

    public boolean hasMoreElements() {
        if (entry != null) {
            return true;
        }
        while (index-- > 0) {
            if ((entry = table[index]) != null) {
                return true;
            }
        }
        return false;
}

public Object nextElement() {
    if (entry == null) {
        while ((index-- > 0) && ((entry = table[index]) == null));
    }
    if (entry != null) {
            IdentityHashtableEntry e = entry;
        entry = e.next;
        return keys ? e.key : e.value;
    }
        throw new NoSuchElementException("IdentityHashtableEnumerator");
    }
}
