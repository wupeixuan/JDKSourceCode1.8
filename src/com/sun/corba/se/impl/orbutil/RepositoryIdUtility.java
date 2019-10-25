/*
 * Copyright (c) 2000, 2004, Oracle and/or its affiliates. All rights reserved.
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

import org.omg.CORBA.ORB;
import com.sun.corba.se.impl.util.RepositoryId;

/**
 * Utility methods for working with repository IDs.
 */
public interface RepositoryIdUtility
{
    boolean isChunkedEncoding(int valueTag);
    boolean isCodeBasePresent(int valueTag);

    // These are currently the same in both RepositoryId and
    // RepositoryId_1_3, but provide the constants again here
    // to eliminate awkardness when using this interface.
    int NO_TYPE_INFO = RepositoryId.kNoTypeInfo;
    int SINGLE_REP_TYPE_INFO = RepositoryId.kSingleRepTypeInfo;
    int PARTIAL_LIST_TYPE_INFO = RepositoryId.kPartialListTypeInfo;

    // Determine how many (if any) repository IDs follow the value
    // tag.
    int getTypeInfo(int valueTag);

    // Accessors for precomputed value tags
    int getStandardRMIChunkedNoRepStrId();
    int getCodeBaseRMIChunkedNoRepStrId();
    int getStandardRMIChunkedId();
    int getCodeBaseRMIChunkedId();
    int getStandardRMIUnchunkedId();
    int getCodeBaseRMIUnchunkedId();
    int getStandardRMIUnchunkedNoRepStrId();
    int getCodeBaseRMIUnchunkedNoRepStrId();
}
