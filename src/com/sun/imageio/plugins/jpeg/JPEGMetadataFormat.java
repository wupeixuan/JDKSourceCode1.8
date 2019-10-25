/*
 * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
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

import javax.imageio.metadata.IIOMetadataFormat;
import javax.imageio.metadata.IIOMetadataFormatImpl;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.plugins.jpeg.JPEGQTable;
import javax.imageio.plugins.jpeg.JPEGHuffmanTable;

import java.util.List;
import java.util.ArrayList;

abstract class JPEGMetadataFormat extends IIOMetadataFormatImpl {
    // 2-byte length reduces max to 65533
    private static final int MAX_JPEG_DATA_SIZE = 65533;

    String resourceBaseName = this.getClass().getName() + "Resources";

    JPEGMetadataFormat(String formatName, int childPolicy) {
        super(formatName, childPolicy);
        setResourceBaseName(resourceBaseName);
    }

    // Format shared between image and stream formats
    void addStreamElements(String parentName) {
        addElement("dqt", parentName, 1, 4);

        addElement("dqtable", "dqt", CHILD_POLICY_EMPTY);

        addAttribute("dqtable",
                     "elementPrecision",
                     DATATYPE_INTEGER,
                     false,
                     "0");
        List tabids = new ArrayList();
        tabids.add("0");
        tabids.add("1");
        tabids.add("2");
        tabids.add("3");
        addAttribute("dqtable",
                     "qtableId",
                     DATATYPE_INTEGER,
                     true,
                     null,
                     tabids);
        addObjectValue("dqtable",
                       JPEGQTable.class,
                       true,
                       null);

        addElement("dht", parentName, 1, 4);
        addElement("dhtable", "dht", CHILD_POLICY_EMPTY);
        List classes = new ArrayList();
        classes.add("0");
        classes.add("1");
        addAttribute("dhtable",
                     "class",
                     DATATYPE_INTEGER,
                     true,
                     null,
                     classes);
        addAttribute("dhtable",
                     "htableId",
                     DATATYPE_INTEGER,
                     true,
                     null,
                     tabids);
        addObjectValue("dhtable",
                       JPEGHuffmanTable.class,
                       true,
                       null);


        addElement("dri", parentName, CHILD_POLICY_EMPTY);
        addAttribute("dri",
                     "interval",
                     DATATYPE_INTEGER,
                     true,
                     null,
                     "0", "65535",
                     true, true);

        addElement("com", parentName, CHILD_POLICY_EMPTY);
        addAttribute("com",
                     "comment",
                     DATATYPE_STRING,
                     false,
                     null);
        addObjectValue("com", byte[].class, 1, MAX_JPEG_DATA_SIZE);

        addElement("unknown", parentName, CHILD_POLICY_EMPTY);
        addAttribute("unknown",
                     "MarkerTag",
                     DATATYPE_INTEGER,
                     true,
                     null,
                     "0", "255",
                     true, true);
        addObjectValue("unknown", byte[].class, 1, MAX_JPEG_DATA_SIZE);
    }

    public boolean canNodeAppear(String elementName,
                                 ImageTypeSpecifier imageType) {
        // Just check if it appears in the format
        if (isInSubtree(elementName, getRootName())){
            return true;
        }
        return false;
    }

    /**
     * Returns <code>true</code> if the named element occurs in the
     * subtree of the format starting with the node named by
     * <code>subtreeName</code>, including the node
     * itself.  <code>subtreeName</code> may be any node in
     * the format.  If it is not, an
     * <code>IllegalArgumentException</code> is thrown.
     */
    protected boolean isInSubtree(String elementName,
                                  String subtreeName) {
        if (elementName.equals(subtreeName)) {
            return true;
        }
        String [] children = getChildNames(elementName);
        for (int i=0; i < children.length; i++) {
            if (isInSubtree(elementName, children[i])) {
                return true;
            }
        }
        return false;
    }

}
