/*
 * Copyright (c) 2001, 2005, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.imageio.plugins.jpeg;

import java.util.ListResourceBundle;

public class JPEGStreamMetadataFormatResources
       extends JPEGMetadataFormatResources {

    public JPEGStreamMetadataFormatResources() {}

    protected Object[][] getContents() {
        // return a copy of commonContents; in theory we want a deep clone
        // of commonContents, but since it only contains (immutable) Strings,
        // this shallow copy is sufficient
        Object[][] commonCopy = new Object[commonContents.length][2];
        for (int i = 0; i < commonContents.length; i++) {
            commonCopy[i][0] = commonContents[i][0];
            commonCopy[i][1] = commonContents[i][1];
        }
        return commonCopy;
    }
}
