/*
 * Copyright (c) 1996, 1998, Oracle and/or its affiliates. All rights reserved.
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
 * (C) Copyright Taligent, Inc. 1996 - All Rights Reserved
 * (C) Copyright IBM Corp. 1996 - All Rights Reserved
 *
 *   The original version of this source code and documentation is copyrighted
 * and owned by Taligent, Inc., a wholly-owned subsidiary of IBM. These
 * materials are provided under terms of a License Agreement between Taligent
 * and Sun. This technology is protected by multiple US and International
 * patents. This notice and attribution to Taligent may not be removed.
 *   Taligent is a registered trademark of Taligent, Inc.
 *
 */

package java.text;

/**
 * This is used for building contracting character tables.  entryName
 * is the contracting character name and value is its collation
 * order.
 */
final class EntryPair
{
    public String entryName;
    public int value;
    public boolean fwd;

    public EntryPair(String name, int value) {
        this(name, value, true);
    }
    public EntryPair(String name, int value, boolean fwd) {
        this.entryName = name;
        this.value = value;
        this.fwd = fwd;
    }
}
